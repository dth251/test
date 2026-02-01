package com.example.Elearning.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class CourseDTO {
    private String title;
    private String description;
    private BigDecimal price;

    // Chỉ nhận ID, không nhận cả object User hay Category
    private Long teacherId;
    private Long categoryId;

    // Danh sách con
    private List<ChapterDTO> chapters;
    private List<QuizDTO> quizzes;
    private List<AttachmentDTO> attachments;

    // Inner Class cho gọn
    @Data
    public static class ChapterDTO {
        private String title;
        private String description;
    }

    @Data
    public static class QuizDTO {
        private String title;
    }

    @Data
    public static class AttachmentDTO {
        private String url;
    }
}