package com.example.Elearning.repository;

import com.example.Elearning.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    // Xem lịch sử mua hàng của một học sinh
    List<Purchase> findByStudent_UserId(Long studentId);

    // Kiểm tra xem học sinh này đã mua khóa học kia chưa (Tránh mua trùng)
    boolean existsByStudent_UserIdAndCourse_CourseId(Long studentId, Long courseId);
}