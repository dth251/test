package com.example.Elearning.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Optional;

@Entity
@Table(name = "users")
@Data // Lombok tự tạo Getter, Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id") // Ánh xạ đúng tên cột trong SQL
    private Long userId;

    private String name;
    private String email;
    private String password;

    // Trong Diagram: Admin, Teacher, Student là class con.
    // Trong Database: Ta dùng cột role để phân biệt.
    private String role; // "ADMIN", "TEACHER", "STUDENT"

}