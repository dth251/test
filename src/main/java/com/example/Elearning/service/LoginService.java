package com.example.Elearning.service;

import com.example.Elearning.entity.User;
import com.example.Elearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public String register(User user) {
        // Sử dụng existsByEmail để kiểm tra trùng lặp cho chuyên nghiệp
        if (userRepository.existsByEmail(user.getEmail())) {
            return "Email này đã được sử dụng!";
        }
        if (userRepository.findByName(user.getName()).isPresent()) {
            return "Tên người dùng đã tồn tại!";
        }
        userRepository.save(user);
        return "Đăng ký thành công!";
    }

    public String login(String name, String password) {
        // 1. Tìm user bằng hàm findByName đã khai báo trong Repository
        Optional<User> userOpt = userRepository.findByName(name);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            // 2. So sánh mật khẩu (Lưu ý: getPassword() viết thường chữ p)
            if (user.getPassword().equals(password)) {
                return "Đăng nhập thành công! Chào mừng " + user.getRole();
            }
        }
        return "Sai tài khoản hoặc mật khẩu!";
    }
}