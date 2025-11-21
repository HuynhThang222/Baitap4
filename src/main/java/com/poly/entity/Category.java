package com.poly.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category_name", columnDefinition = "NVARCHAR(200)")
    private String categoryName; // Đây là field cho setCategoryName

    @Column(name = "images", columnDefinition = "NVARCHAR(500)")
    private String images;       // Đây là field cho setImages

    @Column(name = "status")
    private int status;          // Đây là field cho setStatus

    // Quan hệ: Category thuộc về 1 User (Người quản lý)
    // Nếu bảng của bạn chưa có cột username khóa ngoại thì có thể comment lại dòng này tạm thời
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    // Quan hệ: Category có nhiều Video
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Video> videos;

    // ==============================================================
    // CONSTRUCTOR (Bắt buộc phải có Constructor rỗng)
    // ==============================================================
    public Category() {
    }

    // ==============================================================
    // GETTER & SETTER (Cần thiết để Controller gọi được)
    // ==============================================================

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    // Hàm này sửa lỗi cate.setCategoryName(name)
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    // Hàm này sửa lỗi cate.setImages(fname)
    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    // Hàm này sửa lỗi cate.setStatus(status)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}