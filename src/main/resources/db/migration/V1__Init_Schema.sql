-- 1. Bảng Categories
CREATE TABLE categories (
                            category_id BIGSERIAL PRIMARY KEY, -- Đã đổi thành BIGSERIAL
                            name VARCHAR(100) NOT NULL UNIQUE
);

-- 2. Bảng Users
CREATE TABLE users (
                       user_id BIGSERIAL PRIMARY KEY, -- Đã đổi thành BIGSERIAL
                       name VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(20) NOT NULL
);

-- 3. Bảng Courses
CREATE TABLE courses (
                         course_id BIGSERIAL PRIMARY KEY, -- Đã đổi thành BIGSERIAL
                         title VARCHAR(200) NOT NULL,
                         description TEXT,
                         price DECIMAL(10, 2) NOT NULL,
                         teacher_id BIGINT NOT NULL, -- Khóa ngoại cũng phải là BIGINT
                         category_id BIGINT,         -- Khóa ngoại cũng phải là BIGINT
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         CONSTRAINT fk_course_teacher FOREIGN KEY (teacher_id) REFERENCES users(user_id),
                         CONSTRAINT fk_course_category FOREIGN KEY (category_id) REFERENCES categories(category_id)
);

-- 4. Bảng Purchases
CREATE TABLE purchases (
                           purchase_id BIGSERIAL PRIMARY KEY, -- Đã đổi thành BIGSERIAL
                           user_id BIGINT NOT NULL,
                           course_id BIGINT NOT NULL,
                           purchase_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           CONSTRAINT fk_purchase_user FOREIGN KEY (user_id) REFERENCES users(user_id),
                           CONSTRAINT fk_purchase_course FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

-- 5. Các bảng con
CREATE TABLE chapters (
                          chapter_id BIGSERIAL PRIMARY KEY, -- Đã đổi thành BIGSERIAL
                          title VARCHAR(200) NOT NULL,
                          description TEXT,
                          course_id BIGINT NOT NULL,
                          CONSTRAINT fk_chapter_course FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

CREATE TABLE quizzes (
                         quiz_id BIGSERIAL PRIMARY KEY, -- Đã đổi thành BIGSERIAL
                         title VARCHAR(200) NOT NULL,
                         course_id BIGINT NOT NULL,
                         CONSTRAINT fk_quiz_course FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

CREATE TABLE attachments (
                             attachment_id BIGSERIAL PRIMARY KEY, -- Đã đổi thành BIGSERIAL
                             url VARCHAR(500) NOT NULL,
                             course_id BIGINT NOT NULL,
                             CONSTRAINT fk_attachment_course FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);