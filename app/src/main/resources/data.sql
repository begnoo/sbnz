-- 
-- users
-- 
INSERT INTO users (id, email, password, first_name, last_name) VALUES (1, 'admin@admin.com', 'admin123', 'Mirko', 'Mirkovic');

-- 
-- q&a
-- 
INSERT INTO question (id, question) VALUES (1, 'Where is the squealing noise coming from?');
INSERT INTO answer (id, answer_text) VALUES (1, 'The engine');


INSERT INTO question (id, question) VALUES (2, 'Does the pedal go close to the floor?');
INSERT INTO answer (id, answer_text) VALUES (3, 'Yes'), (4, 'No');
INSERT INTO answer (id, answer_text, follow_up_question_id) VALUES (2, 'The brakes', 2);

INSERT INTO question_answers (question_id, answers_id) VALUES (1, 1), (1, 2);
INSERT INTO question_answers (question_id, answers_id) VALUES (2, 3), (2, 4);
