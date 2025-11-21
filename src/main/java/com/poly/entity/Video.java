package com.poly.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "videos")
@Data
@NoArgsConstructor
@AllArgsConstructor
// Định nghĩa sẵn câu lệnh tìm kiếm để dùng cho nhanh (Optional)
@NamedQuery(name = "Video.findByTitle", query = "SELECT v FROM Video v WHERE v.title LIKE :keyword")
public class Video implements Serializable {

    @Id
    @Column(name = "video_id")
    private String videoId; // ID dạng chuỗi (Ví dụ: V001, YoutubeID)

    @Column(name = "title", columnDefinition = "NVARCHAR(200)")
    private String title;

    @Column(name = "poster")
    private String poster; // Link ảnh thumb

    @Column(name = "views")
    private int views = 0;

    @Column(name = "description", columnDefinition = "NVARCHAR(MAX)")
    private String description;

    @Column(name = "active")
    private boolean active = true;

    // Quan hệ N-1: Video thuộc về 1 Category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}