package com.example.Elearning.repository;

import com.example.Elearning.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Tìm khóa học theo tên (Chức năng Search)
    List<Course> findByTitleContainingIgnoreCase(String keyword);

    // Lấy danh sách khóa học của một giáo viên cụ thể
    List<Course> findByTeacher_UserId(Long teacherId);

    // Lấy danh sách khóa học thuộc một danh mục (VD: Lấy tất cả khóa IT)
    List<Course> findByCategory_CategoryId(Long categoryId);
}