package com.example.Elearning.service;

import com.example.Elearning.dto.UserDTO;
import com.example.Elearning.entity.User;
import com.example.Elearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 1. Chức năng Đăng ký (Tạo User mới)
    public User createUser(UserDTO userDTO) {
        // Kiểm tra xem email đã có người dùng chưa
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new RuntimeException("Email này đã được sử dụng!");
        }

        // Chuyển đổi từ DTO sang Entity để lưu vào Database
        User newUser = new User();
        newUser.setName(userDTO.getName());
        newUser.setEmail(userDTO.getEmail());
        newUser.setPassword(userDTO.getPassword()); // Lưu ý: Tạm thời lưu pass thường, sau này sẽ mã hóa
        newUser.setRole(userDTO.getRole());

        return userRepository.save(newUser);
    }

    // 2. Chức năng Đăng nhập đơn giản
    public User login(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // So sánh password (Tạm thời so sánh chuỗi thường)
            if (user.getPassword().equals(password)) {
                return user; // Đăng nhập thành công
            }
        }
        return null; // Đăng nhập thất bại
    }
}