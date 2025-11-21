package com.poly.controller.web;

import com.poly.dao.CategoryDAO;
import com.poly.dao.VideoDAO;
import com.poly.entity.Category;
import com.poly.entity.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/home", "/login", "/logout"}) // Xử lý cả đăng nhập/xuất ở đây nếu muốn đơn giản
public class HomeController extends HttpServlet {

    private VideoDAO videoDAO = new VideoDAO();
    private CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath(); // Lấy phần đuôi của URL

        // 1. LUÔN LUÔN lấy danh sách Category cho Sidebar (left.jsp)
        // Vì Sitemesh ghép trang nào cũng có sidebar, nên trang nào cũng cần list này
        List<Category> categories = categoryDAO.findAll();
        req.setAttribute("categories", categories);

        if (path.contains("home")) {
            // 2. Lấy danh sách Video cho phần nội dung chính
            List<Video> videos = videoDAO.findAll();
            req.setAttribute("videos", videos);
            
            // Forward về trang chủ
            req.getRequestDispatcher("/views/web/home.jsp").forward(req, resp);
            
        } else if (path.contains("login")) {
            // Chuyển hướng sang trang login (cần tạo file login.jsp riêng)
            req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);
            
        } else if (path.contains("logout")) {
            // Xử lý đăng xuất
            HttpSession session = req.getSession();
            session.removeAttribute("currentUser");
            resp.sendRedirect(req.getContextPath() + "/home");
        }
    }
}