package com.example.Elearning.dto;

import lombok.Data;

@Data
public class PurchaseDTO {
    private Long studentId; // ID người mua
    private Long courseId;  // ID khóa học muốn mua
}