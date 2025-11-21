package com.poly.dao;

import com.poly.config.JPAConfig;
import com.poly.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class CategoryDAO {

    // 1. Hàm insert (được gọi ở dòng: categoryDAO.insert(cate))
    public void insert(Category category) {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(category); // Lưu mới
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    // 2. Hàm update (được gọi ở dòng: categoryDAO.update(cate))
    public void update(Category category) {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(category); // Cập nhật
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    // 3. Hàm delete (được gọi ở dòng: categoryDAO.delete(id))
    public void delete(int id) throws Exception {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            // Phải tìm thấy đối tượng trước mới xóa được
            Category category = em.find(Category.class, id);
            if (category != null) {
                em.remove(category); // Xóa
            } else {
                throw new Exception("Không tìm thấy Category có ID này");
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e; // Ném lỗi ra để Controller bắt được và thông báo
        } finally {
            em.close();
        }
    }

    // 4. Hàm findById (được gọi ở dòng: categoryDAO.findById(id))
    public Category findById(int id) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            return em.find(Category.class, id);
        } finally {
            em.close();
        }
    }

    // 5. Hàm findAll (được gọi ở dòng: categoryDAO.findAll())
    public List<Category> findAll() {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            // JPQL query lấy tất cả
            String jpql = "SELECT c FROM Category c";
            TypedQuery<Category> query = em.createQuery(jpql, Category.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}