package com.example.Elearning.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "courses")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    private String title;
    private String description;
    private BigDecimal price;

    // Quan hệ: Course thuộc về 1 Teacher (User)
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User teacher;

    // Quan hệ: Course thuộc về 1 Category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Quan hệ Composition (Hình thoi đen): 1 Course có nhiều Chapter
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Chapter> chapters;

    // Quan hệ Composition: 1 Course có nhiều Quiz
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Quiz> quizzes;

    // Quan hệ Composition: 1 Course có nhiều Attachment
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Attachment> attachments;
}