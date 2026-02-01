package com.example.Elearning.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "attachments")
@Data
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attachment_id")
    private Long attachmentId;

    private String url;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}