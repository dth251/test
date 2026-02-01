package com.example.Elearning.repository;

import com.example.Elearning.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
    // Lấy tất cả tài liệu đính kèm của một khóa học
    List<Attachment> findByCourse_CourseId(Long courseId);
}