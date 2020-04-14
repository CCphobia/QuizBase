INSERT INTO user (id, login, email, password) VALUES (1, 'login1', 'email1@gmail.com', 'pass1'), (2, 'login2', 'email2@gmail.com', 'pass2');
INSERT INTO category (id, title) VALUES (1, 'History');
INSERT INTO quiz (user_id, title, category_id) VALUES (1, 'quiz1', 1);
INSERT INTO question (id, body, correct_answer, user_id, quiz_title ) VALUES (1, 'body1', 'correct_answer1', 1, 'quiz1')