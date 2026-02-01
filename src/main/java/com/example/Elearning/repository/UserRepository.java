package com.example.Elearning.repository;

import com.example.Elearning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Tìm user theo email (Dùng cho chức năng Đăng nhập)
    Optional<User> findByEmail(String email);

    // Kiểm tra email đã tồn tại chưa (Dùng khi Đăng ký)
    boolean existsByEmail(String email);

    // Lấy danh sách theo vai trò (VD: Lấy tất cả giáo viên hoặc tất cả học sinh)
    List<User> findByRole(String role);

    Optional<User> findByName(String name);
}