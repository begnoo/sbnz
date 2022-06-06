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

-- 
-- sounds like menu
-- 
INSERT INTO question (id, question) VALUES (4, 'What do you hear?');
INSERT INTO answer (id, answer_text, follow_up_question_id) VALUES (8, 'Squealing', 1);
INSERT INTO question_answers (question_id, answers_id) VALUES (4, 8);

-- 
-- main menu
-- 
INSERT INTO question (id, question) VALUES (3, 'What type of symptom do you have?');
INSERT INTO answer (id, answer_text, follow_up_question_id) VALUES (5, 'Sounds like', 4);
INSERT INTO answer (id, answer_text) VALUES (6, 'Looks like');
INSERT INTO answer (id, answer_text) VALUES (7, 'Smells like');

INSERT INTO question_answers (question_id, answers_id) VALUES (3, 5), (3, 6), (3, 7);

-- answer count = 13
-- auestion count = 8

-- 
-- Insturctions
-- 
INSERT INTO instructions (id, part, instructions) VALUES (1, 'DRIVE_BELT', 'Ma nzm brate 1');
INSERT INTO instructions (id, part, instructions) VALUES (2, 'BREAK_PADS', 'Ma nzm brate 2');
INSERT INTO instructions (id, part, instructions) VALUES (3, 'NONE', 'You are overreacting');
INSERT INTO instructions (id, part, instructions) VALUES (4, 'MAJOR_DRIVE_BELT', 'Ma nzm brate ovo je vec ozbiljno');

--
-- obd
-- 
INSERT INTO question (id, question) VALUES (5, 'What is your OBD fault code?');
INSERT INTO question (id, question) VALUES (6, 'Does your car ride roughly?');
INSERT INTO question (id, question) VALUES (8, 'Does it leak under your vechicle?');
INSERT INTO answer (id, answer_text, follow_up_question_id) VALUES (9, 'P0300', 6);
INSERT INTO answer (id, answer_text, follow_up_question_id) VALUES (18, 'P0440', 8);

INSERT INTO question (id, question) VALUES (7, 'Do your spark plugs work?');
INSERT INTO question (id, question) VALUES (9, 'Is your vapor sensor faulty?');
INSERT INTO answer (id, answer_text, follow_up_question_id) VALUES (10, 'Yes', 7);

INSERT INTO answer (id, answer_text, follow_up_question_id) VALUES (15, 'No', 9);
INSERT INTO answer (id, answer_text) VALUES (11, 'Yes'), (12, 'No'), (13, 'No'), (14, 'Yes'), (16, 'Yes'), (17, 'No');

INSERT INTO question_answers (question_id, answers_id) VALUES (5, 9), (5, 18), (6, 10), (6, 13), (7, 11), (7, 12), (8, 14), (8, 15), (9, 16), (9, 17);

INSERT INTO instructions (id, part, instructions) VALUES (5, 'SPARK_PLUGS', 'Change your spark plugs.');
INSERT INTO instructions (id, part, instructions) VALUES (6, 'RESET_OBD', 'OBD connector made an error. Restart it.');
INSERT INTO instructions (id, part, instructions) VALUES (7, 'FUEL_TANK', 'Your fuel tank is probably leaking. Visit your mechanic.');
INSERT INTO instructions (id, part, instructions) VALUES (8, 'VAPOR_SENSOR', 'Change your vapor sensor.');




