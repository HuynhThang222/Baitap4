package com.poly.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Class tiện ích để quản lý EntityManagerFactory và EntityManager
 */
public class JPAConfig {

    // Factory tạo ra EntityManager (Nên là Singleton - chỉ tạo 1 lần duy nhất)
    private static EntityManagerFactory factory;

    /**
     * Phương thức lấy EntityManager để bắt đầu làm việc với DB
     */
    public static EntityManager getEntityManager() {
        // Kiểm tra nếu factory chưa có hoặc đã bị đóng thì tạo mới
        if (factory == null || !factory.isOpen()) {
            // "JPA_Unit" là tên định nghĩa trong file persistence.xml
            // Nếu bạn đặt tên khác, hãy sửa lại dòng này cho khớp
            factory = Persistence.createEntityManagerFactory("JPA_Unit");
        }
        return factory.createEntityManager();
    }

    /**
     * Đóng Factory khi ứng dụng kết thúc (Optional)
     */
    public static void close() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }
    
    // Hàm main để test kết nối ngay lập tức
    public static void main(String[] args) {
        try {
            EntityManager em = getEntityManager();
            System.out.println("----- KẾT NỐI THÀNH CÔNG! -----");
            System.out.println("EntityManager: " + em);
            em.close();
        } catch (Exception e) {
            System.out.println("----- KẾT NỐI THẤT BẠI! -----");
            e.printStackTrace();
        }
    }
}