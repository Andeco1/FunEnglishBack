-- Create tables
CREATE TABLE level (
    level_id SERIAL PRIMARY KEY,
    code VARCHAR(255) NOT NULL UNIQUE,
    description VARCHAR(255)
);

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    login VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL
);

CREATE TABLE lesson (
    lesson_id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    level_id INTEGER NOT NULL REFERENCES level(level_id)
);

CREATE TABLE test (
    test_id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    level_id INTEGER NOT NULL REFERENCES level(level_id)
);

CREATE TABLE question (
    question_id SERIAL PRIMARY KEY,
    test_id BIGINT NOT NULL REFERENCES test(test_id),
    question_text TEXT NOT NULL,
    points BIGINT NOT NULL
);

CREATE TABLE question_opt (
    option_id SERIAL PRIMARY KEY,
    question_id BIGINT NOT NULL REFERENCES question(question_id) ON DELETE CASCADE,
    option_text VARCHAR(255) NOT NULL,
    is_correct BOOLEAN NOT NULL
);

CREATE TABLE users_progress (
    user_id BIGINT NOT NULL REFERENCES users(user_id),
    test_id BIGINT NOT NULL REFERENCES test(test_id),
    score BIGINT,
    passed_at TIMESTAMP WITH TIME ZONE,
    PRIMARY KEY (user_id, test_id)
);

CREATE TABLE review (
    review_id SERIAL PRIMARY KEY,
    client_id BIGINT NOT NULL,
    review_text TEXT NOT NULL,
    rating SMALLINT NOT NULL,
    publication_date DATE NOT NULL
);

CREATE TABLE classroom (
    classroom_id SERIAL PRIMARY KEY,
    name VARCHAR(500) NOT NULL,
    floor INTEGER NOT NULL,
    capacity INTEGER NOT NULL,
    is_available BOOLEAN NOT NULL
);

CREATE TABLE education_program (
    program_id SERIAL PRIMARY KEY,
    price NUMERIC NOT NULL,
    duration NUMERIC
);

-- Insert sample data
INSERT INTO level (code, description) VALUES
('A1', 'Начальный уровень'),
('A2', 'Элементарный уровень'),
('B1', 'Средний уровень'),
('B2', 'Выше среднего'),
('C1', 'Продвинутый уровень');

INSERT INTO users (login, password_hash) VALUES
('ivanov', '$2a$10$example_hash'),
('petrov', '$2a$10$example_hash'),
('sidorov', '$2a$10$example_hash');

INSERT INTO lesson (title, content, level_id) VALUES
('Present Simple', 'Урок о настоящем простом времени в английском языке...', 1),
('Past Simple', 'Урок о прошедшем простом времени...', 1),
('Future Simple', 'Урок о будущем простом времени...', 2);

INSERT INTO test (title, level_id) VALUES
('Тест на Present Simple', 1),
('Тест на Past Simple', 1),
('Тест на Future Simple', 2);

INSERT INTO question (test_id, question_text, points) VALUES
(1, 'Выберите правильный вариант: I ___ to school every day.', 5),
(1, 'She ___ English very well.', 5),
(2, 'Yesterday I ___ to the cinema.', 5);

INSERT INTO question_opt (question_id, option_text, is_correct) VALUES
(1, 'go', true),
(1, 'goes', false),
(1, 'going', false),
(1, 'went', false),
(2, 'speak', false),
(2, 'speaks', true),
(2, 'speaking', false),
(2, 'spoke', false),
(3, 'go', false),
(3, 'goes', false),
(3, 'went', true),
(3, 'going', false);

INSERT INTO users_progress (user_id, test_id, score, passed_at) VALUES
(1, 1, 8, CURRENT_TIMESTAMP),
(1, 2, 10, CURRENT_TIMESTAMP),
(2, 1, 5, CURRENT_TIMESTAMP);

INSERT INTO review (client_id, review_text, rating, publication_date) VALUES
(1, 'Отличная платформа для изучения английского!', 5, CURRENT_DATE),
(2, 'Хорошие уроки, но можно добавить больше практики', 4, CURRENT_DATE);

INSERT INTO classroom (name, floor, capacity, is_available) VALUES
('Аудитория 101', 1, 20, true),
('Аудитория 202', 2, 15, true),
('Аудитория 303', 3, 25, false);

INSERT INTO education_program (price, duration) VALUES
(15000.00, 3),
(25000.00, 6),
(35000.00, 12); 