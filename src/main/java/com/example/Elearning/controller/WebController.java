package com.example.Elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Dùng @Controller thay vì @RestController để trả về giao diện HTML
public class WebController {

    @GetMapping("/login") // Đường dẫn bạn sẽ gõ trên trình duyệt
    public String showAuthPage() {
        return "login"; // Trả về tên file HTML (không cần đuôi .html)
    }
    @GetMapping("/home") // Thêm đường dẫn này
    public String showHomePage() {
        return "home"; // Trả về home.html trong templates
    }
}