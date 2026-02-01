package com.example.Elearning.service;

import com.example.Elearning.dto.CourseDTO;
import com.example.Elearning.entity.*;
import com.example.Elearning.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional // Đảm bảo lưu thành công tất cả hoặc không lưu gì cả (Rollback)
    public Course createCourse(CourseDTO dto) {
        // 1. Tìm Teacher
        User teacher = userRepository.findById(dto.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Giáo viên không tồn tại!"));

        // 2. Tìm Category
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Danh mục không tồn tại!"));

        // 3. Tạo Course (Cha)
        Course course = new Course();
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setPrice(dto.getPrice());
        course.setTeacher(teacher);
        course.setCategory(category);

        // 4. Map Chapters (Con)
        if (dto.getChapters() != null) {
            List<Chapter> chapters = new ArrayList<>();
            for (CourseDTO.ChapterDTO chapDto : dto.getChapters()) {
                Chapter chap = new Chapter();
                chap.setTitle(chapDto.getTitle());
                chap.setDescription(chapDto.getDescription());
                chap.setCourse(course); // Gán cha
                chapters.add(chap);
            }
            course.setChapters(chapters);
        }

        // 5. Map Quizzes (Con)
        if (dto.getQuizzes() != null) {
            List<Quiz> quizzes = new ArrayList<>();
            for (CourseDTO.QuizDTO quizDto : dto.getQuizzes()) {
                Quiz quiz = new Quiz();
                quiz.setTitle(quizDto.getTitle());
                quiz.setCourse(course); // Gán cha
                quizzes.add(quiz);
            }
            course.setQuizzes(quizzes);
        }

        // 6. Map Attachments (Con)
        if (dto.getAttachments() != null) {
            List<Attachment> attachments = new ArrayList<>();
            for (CourseDTO.AttachmentDTO attDto : dto.getAttachments()) {
                Attachment att = new Attachment();
                att.setUrl(attDto.getUrl());
                att.setCourse(course); // Gán cha
                attachments.add(att);
            }
            course.setAttachments(attachments);
        }

        // 7. Lưu tất cả (Cascade)
        return courseRepository.save(course);
    }

    // 1. Lấy danh sách khóa học của Giáo viên
    public List<Course> getCoursesByTeacher(Long teacherId) {
        return courseRepository.findByTeacher_UserId(teacherId);
    }

    // 2. Tìm kiếm khóa học cho mọi người
    public List<Course> searchCourses(String keyword) {
        return courseRepository.findByTitleContainingIgnoreCase(keyword);
    }
}