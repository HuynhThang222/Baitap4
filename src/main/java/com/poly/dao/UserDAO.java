package com.poly.dao;

import com.poly.config.JPAConfig;
import com.poly.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UserDAO {

    // Dùng cho Đăng nhập & Tìm kiếm thông tin Profile
    public User findById(String username) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            return em.find(User.class, username);
        } finally {
            em.close();
        }
    }

    // Dùng cho chức năng Cập nhật Profile
    public void update(User user) {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(user); // Cập nhật thông tin user
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    
    // Insert user mới (cho chức năng Đăng ký)
    public void insert(User user) {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}