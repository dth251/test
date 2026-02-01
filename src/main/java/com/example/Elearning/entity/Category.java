package com.example.Elearning.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    private String name;

    // Quan hệ 1-N: Một danh mục có nhiều khóa học
    @OneToMany(mappedBy = "category")
    private List<Course> courses;
}