package com.example.Elearning.repository;

import com.example.Elearning.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    // Lấy tất cả bài kiểm tra của một khóa học
    List<Quiz> findByCourse_CourseId(Long courseId);
}