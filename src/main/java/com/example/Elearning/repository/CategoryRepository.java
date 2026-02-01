package com.example.Elearning.repository;

import com.example.Elearning.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Tìm danh mục theo tên (VD: tìm xem có danh mục "Java" chưa)
    Category findByName(String name);
}