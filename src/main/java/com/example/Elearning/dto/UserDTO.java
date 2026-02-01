package com.example.Elearning.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String email;
    private String password;
    private String role; // Người dùng sẽ gửi lên: "STUDENT", "TEACHER"
}