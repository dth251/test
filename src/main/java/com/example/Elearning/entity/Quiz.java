package com.example.Elearning.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "quizzes")
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private Long quizId;

    private String title;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}