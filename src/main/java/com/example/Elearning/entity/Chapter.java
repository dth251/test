package com.example.Elearning.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "chapters")
@Data
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chapter_id")
    private Long chapterId;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}