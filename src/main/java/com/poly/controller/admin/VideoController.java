package com.poly.controller.admin;

import com.poly.dao.VideoDAO;
import com.poly.entity.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/videos"}) // Chỉ một đường dẫn chính
public class VideoController extends HttpServlet {

    private VideoDAO videoDAO = new VideoDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        // Lấy từ khóa tìm kiếm từ URL (ví dụ: /admin/videos?keyword=java)
        String keyword = req.getParameter("keyword");
        
        List<Video> list;
        
        if (keyword != null && !keyword.trim().isEmpty()) {
            // Nếu có từ khóa -> Gọi hàm tìm kiếm
            list = videoDAO.findByTitle(keyword);
            req.setAttribute("message", "Kết quả tìm kiếm cho: " + keyword);
        } else {
            // Nếu không có từ khóa -> Gọi hàm lấy tất cả
            list = videoDAO.findAll();
        }

        // Đẩy list video sang view
        req.setAttribute("videos", list);
        
        // Giữ lại keyword trong ô input để người dùng biết mình đang tìm gì
        req.setAttribute("searchKeyword", keyword); 

        req.getRequestDispatcher("/views/admin/video-list.jsp").forward(req, resp);
    }
}