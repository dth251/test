package com.example.Elearning.controller;

import com.example.Elearning.dto.UserDTO;
import com.example.Elearning.entity.User;
import com.example.Elearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users") // Đường dẫn gốc: http://localhost:8080/api/users
public class UserController {

    @Autowired
    private UserService userService;

    // API Đăng ký: POST http://localhost:8080/api/users/register
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        try {
            User createdUser = userService.createUser(userDTO);
            return ResponseEntity.ok(createdUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // Trả về lỗi nếu email trùng
        }
    }

    // API Đăng nhập: POST http://localhost:8080/api/users/login
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDTO userDTO) {
        User user = userService.login(userDTO.getEmail(), userDTO.getPassword());

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(401).body("Email hoặc mật khẩu không đúng!");
        }
    }
}