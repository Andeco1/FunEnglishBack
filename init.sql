-- Create sample users
INSERT INTO users (username, password, email, role)
VALUES 
    ('admin', '$2a$10$xn3LI/AjqicFYZFruSwve.681477XaVNaUQbr1gioaWPn4t1KsnmG', 'admin@example.com', 'ADMIN'),
    ('user1', '$2a$10$xn3LI/AjqicFYZFruSwve.681477XaVNaUQbr1gioaWPn4t1KsnmG', 'user1@example.com', 'USER')
ON CONFLICT (username) DO NOTHING;

-- Create sample words
INSERT INTO words (word, translation, difficulty_level, category)
VALUES 
    ('hello', 'привет', 'EASY', 'GREETINGS'),
    ('goodbye', 'до свидания', 'EASY', 'GREETINGS'),
    ('computer', 'компьютер', 'MEDIUM', 'TECHNOLOGY'),
    ('programming', 'программирование', 'HARD', 'TECHNOLOGY')
ON CONFLICT (word) DO NOTHING;

-- Create sample sentences
INSERT INTO sentences (text, translation, difficulty_level)
VALUES 
    ('Hello, how are you?', 'Привет, как дела?', 'EASY'),
    ('I am learning programming.', 'Я учусь программированию.', 'MEDIUM'),
    ('The computer is a useful tool.', 'Компьютер - полезный инструмент.', 'MEDIUM')
ON CONFLICT (text) DO NOTHING; 