package com.example.Elearning.repository;

import com.example.Elearning.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Long> {
    // Lấy tất cả chương học của một khóa học
    List<Chapter> findByCourse_CourseId(Long courseId);
}