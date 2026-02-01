package com.example.Elearning.service;

import com.example.Elearning.entity.Course;
import com.example.Elearning.entity.Purchase;
import com.example.Elearning.entity.User;
import com.example.Elearning.repository.CourseRepository;
import com.example.Elearning.repository.PurchaseRepository;
import com.example.Elearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;

    public Purchase buyCourse(Long studentId, Long courseId) {
        // 1. Kiểm tra xem đã mua chưa?
        if (purchaseRepository.existsByStudent_UserIdAndCourse_CourseId(studentId, courseId)) {
            throw new RuntimeException("Bạn đã đăng ký khóa học này rồi!");
        }

        // 2. Lấy thông tin User và Course
        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Học viên không tồn tại!"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Khóa học không tồn tại!"));

        // 3. Tạo bản ghi mua hàng
        Purchase purchase = new Purchase();
        purchase.setStudent(student); // Gán người mua
        purchase.setCourse(course);   // Gán khóa học
        purchase.setPurchaseDate(LocalDateTime.now()); // Lấy thời gian hiện tại

        return purchaseRepository.save(purchase);
    }
    public List<Course> getMyCourses(Long studentId) {
        // 1. Lấy lịch sử mua hàng từ bảng Purchase
        List<Purchase> purchases = purchaseRepository.findByStudent_UserId(studentId);

        // 2. Trích xuất (Map) ra danh sách Course tương ứng
        return purchases.stream()
                .map(Purchase::getCourse)
                .collect(Collectors.toList());
    }
}