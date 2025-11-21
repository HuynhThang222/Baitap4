package com.poly.dao;

import com.poly.config.JPAConfig;
import com.poly.entity.Video;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class VideoDAO {

    // INSERT
    public void insert(Video video) {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(video);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    // UPDATE
    public void update(Video video) {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(video);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    // DELETE
    public void delete(String videoId) throws Exception {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            Video video = em.find(Video.class, videoId);
            if (video != null) {
                em.remove(video);
            } else {
                throw new Exception("Video không tồn tại");
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Video findById(String videoId) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            return em.find(Video.class, videoId);
        } finally {
            em.close();
        }
    }

    public List<Video> findAll() {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            return em.createQuery("SELECT v FROM Video v", Video.class).getResultList();
        } finally {
            em.close();
        }
    }

    // === YÊU CẦU: TÌM KIẾM VIDEO THEO TIÊU ĐỀ ===
    public List<Video> findByTitle(String keyword) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            String jpql = "SELECT v FROM Video v WHERE v.title LIKE :keyword";
            TypedQuery<Video> query = em.createQuery(jpql, Video.class);
            query.setParameter("keyword", "%" + keyword + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    // === HỖ TRỢ: LỌC VIDEO THEO CATEGORY ===
    public List<Video> findByCategoryId(int cateId) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            String jpql = "SELECT v FROM Video v WHERE v.category.categoryId = :cateId";
            TypedQuery<Video> query = em.createQuery(jpql, Video.class);
            query.setParameter("cateId", cateId);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}