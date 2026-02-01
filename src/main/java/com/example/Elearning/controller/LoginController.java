package com.example.Elearning.controller;
import com.example.Elearning.entity.User;
import com.example.Elearning.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // Quan trọng để HTML gọi được API
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody User user) {
        return Map.of("message", loginService.register(user));
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> loginData) {
        // Lấy 'name' và 'password' từ JSON gửi lên
        String result = loginService.login(loginData.get("name"), loginData.get("password"));
        return Map.of("message", result);
    }
}