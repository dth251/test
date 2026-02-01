package com.example.Elearning.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchases")
@Data
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private Long purchaseId;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;

    // Liên kết với Student
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User student;

    // Liên kết với Course
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}