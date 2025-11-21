package com.poly.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data // Lombok tự sinh Getter, Setter, toString...
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "fullname", columnDefinition = "NVARCHAR(100)")
    private String fullname;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "admin")
    private boolean admin = false;

    @Column(name = "active")
    private boolean active = true;
    
    @Column(name = "images")
    private String images; // Avatar

    // Quan hệ 1-N: Một User (Admin) có thể tạo/quản lý nhiều Category
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Category> categories;
}