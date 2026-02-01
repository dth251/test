package com.example.Elearning.controller;

import com.example.Elearning.dto.PurchaseDTO;
import com.example.Elearning.entity.Course;
import com.example.Elearning.entity.Purchase;
import com.example.Elearning.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    // API Mua khóa học: POST http://localhost:8080/api/purchases
    @PostMapping
    public ResponseEntity<?> buyCourse(@RequestBody PurchaseDTO purchaseDTO) {
        try {
            Purchase newPurchase = purchaseService.buyCourse(
                    purchaseDTO.getStudentId(),
                    purchaseDTO.getCourseId()
            );
            return ResponseEntity.ok(newPurchase);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Course>> getStudentCourses(@PathVariable Long studentId) {
        List<Course> courses = purchaseService.getMyCourses(studentId);
        return ResponseEntity.ok(courses);
    }
}