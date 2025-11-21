package com.poly.controller.admin;

import com.poly.dao.CategoryDAO;
import com.poly.entity.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@MultipartConfig // Bắt buộc để hứng file upload (ảnh danh mục)
@WebServlet(urlPatterns = {
    "/admin/categories",        // Hiện danh sách
    "/admin/category/add",      // Hiện form thêm mới
    "/admin/category/insert",   // Xử lý thêm mới (POST)
    "/admin/category/edit",     // Hiện form sửa
    "/admin/category/update",   // Xử lý sửa (POST)
    "/admin/category/delete",   // Xử lý xóa
    "/admin/category/search"    // Tìm kiếm (nếu cần)
})
public class CategoryController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        if (url.contains("categories")) {
            // 1. HIỆN DANH SÁCH
            List<Category> list = categoryDAO.findAll();
            req.setAttribute("listCate", list);
            req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);

        } else if (url.contains("add")) {
            // 2. HIỆN FORM THÊM MỚI (Form trống)
            req.getRequestDispatcher("/views/admin/category-form.jsp").forward(req, resp);

        } else if (url.contains("edit")) {
            // 3. HIỆN FORM SỬA (Form có dữ liệu cũ)
            int id = Integer.parseInt(req.getParameter("id"));
            Category category = categoryDAO.findById(id);
            req.setAttribute("cate", category); // Đẩy đối tượng cũ sang view để hiện lên input
            req.getRequestDispatcher("/views/admin/category-form.jsp").forward(req, resp);

        } else if (url.contains("delete")) {
            // 4. XÓA
            try {
                int id = Integer.parseInt(req.getParameter("id"));
                categoryDAO.delete(id);
                req.setAttribute("message", "Xóa thành công!");
            } catch (Exception e) {
                req.setAttribute("error", "Lỗi: Không thể xóa danh mục này (có thể do ràng buộc khóa ngoại)!");
            }
            // Xóa xong load lại danh sách
            req.getRequestDispatcher("/admin/categories").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");

        try {
            // Lấy dữ liệu từ form
            Category cate = new Category();
            String name = req.getParameter("categoryName");
            int status = Integer.parseInt(req.getParameter("status"));
            
            cate.setCategoryName(name);
            cate.setStatus(status);

            // XỬ LÝ UPLOAD ẢNH
            String fname = "";
            try {
                Part part = req.getPart("images");
                if (part.getSize() > 0) {
                    String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    // Tạo thư mục uploads nếu chưa có
                    String realPath = req.getServletContext().getRealPath("/uploads");
                    File dir = new File(realPath);
                    if (!dir.exists()) dir.mkdirs();
                    
                    part.write(realPath + "/" + filename);
                    fname = filename; // Lưu tên file vào DB
                } else {
                    // Nếu đang sửa mà không chọn ảnh mới thì giữ ảnh cũ (logic này cần xử lý thêm ở form ẩn)
                    fname = req.getParameter("currentImage"); 
                }
                cate.setImages(fname);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // INSERT hoặc UPDATE
            if (url.contains("insert")) {
                categoryDAO.insert(cate);
                req.setAttribute("message", "Thêm mới thành công!");
            } else if (url.contains("update")) {
                int id = Integer.parseInt(req.getParameter("categoryId"));
                cate.setCategoryId(id); // Update cần ID
                categoryDAO.update(cate);
                req.setAttribute("message", "Cập nhật thành công!");
            }

            // Chuyển hướng về lại trang danh sách
            resp.sendRedirect(req.getContextPath() + "/admin/categories");

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Lỗi thực hiện: " + e.getMessage());
            req.getRequestDispatcher("/views/admin/category-form.jsp").forward(req, resp);
        }
    }
}