INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (name) VALUES ('ROLE_USER');

-- 
-- users
-- admin123 
INSERT INTO users (id, email, password, first_name, last_name) VALUES (1, 'admin@admin.com', '$2a$10$zdgHYg.ORTSj8zGPz4vvqe./lzKGBTKI5pr7HZA9OX/J0pENnsVZK', 'Mirko', 'Mirkovic');
INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);

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


INSERT INTO question (id, question) VALUES (15, 'Does this engine have a low oil level?');
INSERT INTO answer (id, answer_text) VALUES (32, 'Yes');
INSERT INTO answer (id, answer_text) VALUES (33, 'No');

INSERT INTO question_answers (question_id, answers_id) VALUES (15, 32), (15, 33);

INSERT INTO question (id, question) VALUES (14, 'Does the oil light come on?');
INSERT INTO answer (id, answer_text) VALUES (30, 'Yes');
INSERT INTO answer (id, answer_text, follow_up_question_id) VALUES (31, 'No', 15);

INSERT INTO question_answers (question_id, answers_id) VALUES (14, 30), (14, 31);


-- 
-- sounds like menu
-- 
INSERT INTO question (id, question) VALUES (4, 'What do you hear?');
INSERT INTO answer (id, answer_text, follow_up_question_id) VALUES (8, 'Squealing', 1);
INSERT INTO answer (id, answer_text, follow_up_question_id) VALUES (29, 'Tapping', 14);

INSERT INTO question_answers (question_id, answers_id) VALUES (4, 8), (4, 29);

-- 
-- Looks like
-- 

INSERT INTO question (id, question) VALUES (17, 'Where is the steam coming from?');
INSERT INTO answer (id, answer_text) VALUES (35, 'From under the hood');
INSERT INTO answer (id, answer_text) VALUES (36, 'From the exhaust');

INSERT INTO question_answers (question_id, answers_id) VALUES (17, 35), (17, 36);


INSERT INTO question (id, question) VALUES (16, 'What do you see?');
INSERT INTO answer (id, answer_text, follow_up_question_id) VALUES (34, 'Steam', 17);

INSERT INTO question_answers (question_id, answers_id) VALUES (16, 34);

-- 
-- Looks like
-- 

INSERT INTO question (id, question) VALUES (19, 'Check the air filter. Is it dirty?');
INSERT INTO answer (id, answer_text) VALUES (39, 'Yes');
INSERT INTO answer (id, answer_text) VALUES (40, 'No');

INSERT INTO question_answers (question_id, answers_id) VALUES (19, 39), (19, 40);

INSERT INTO question (id, question) VALUES (18, 'What do you smell?');
INSERT INTO answer (id, answer_text, follow_up_question_id) VALUES (37, 'Rotten egg smell', 19);
INSERT INTO answer (id, answer_text) VALUES (38, 'Muddy smell from A/C vents, along with poor cooling');


INSERT INTO question_answers (question_id, answers_id) VALUES (18, 37), (18, 38);


-- 
-- main menu
-- 
INSERT INTO question (id, question) VALUES (3, 'What type of symptom do you have?');
INSERT INTO answer (id, answer_text, follow_up_question_id) VALUES (5, 'Sounds like', 4);
INSERT INTO answer (id, answer_text, follow_up_question_id) VALUES (6, 'Looks like', 16);
INSERT INTO answer (id, answer_text, follow_up_question_id) VALUES (7, 'Smells like', 18);

INSERT INTO question_answers (question_id, answers_id) VALUES (3, 5), (3, 6), (3, 7);

-- answer count = 40
-- question count = 19
-- instructions count = 16

-- 
-- Insturctions
-- 
INSERT INTO instructions (id, part, instructions) VALUES (1, 'DRIVE_BELT', 'This generally indicates either a worn drive belt or faulty alternator. Apply some silicone spray on the underside of the drive belt. This may provide you with some temporary relief of this squealing noise.');
INSERT INTO instructions (id, part, instructions) VALUES (2, 'BREAK_PADS', 'This vehicle needs new brake pads. The noise you are hearing is the brake pad wear sensor. It is designed to let you know your pads are wearing thin.');
INSERT INTO instructions (id, part, instructions) VALUES (3, 'NONE', 'Everything is normal.');
INSERT INTO instructions (id, part, instructions) VALUES (4, 'MAJOR_DRIVE_BELT', 'You should change your drive belt.');
INSERT INTO instructions (id, part, instructions) VALUES (13, 'ENGINE_LUBRICATION', 'You should check your oil pump.');
INSERT INTO instructions (id, part, instructions) VALUES (14, 'ADD_OIL', 'You should add oil to your vehicle.');
INSERT INTO instructions (id, part, instructions) VALUES (15, 'LOOSE_VALVE', 'Loose valves or a leaking exhaust manifold are likely the issue.');
INSERT INTO instructions (id, part, instructions) VALUES (16, 'MAJOR_ENGINE_LUBRICATION', 'Your oil pump is malfunctioning, and could cause further problems.');

INSERT INTO instructions (id, part, instructions) VALUES (17, 'RADIATOR_CAP', 'Check the radiator cap when the engine is cold. If anything seems odd about the radiator cap, replace it and see if this corrects the boil over problem.');
INSERT INTO instructions (id, part, instructions) VALUES (18, 'NONE_EXHAUST', 'This is normal and just condensation steaming off.');

INSERT INTO instructions (id, part, instructions) VALUES (19, 'AIR_FILTER', 'Replace the air filter.');
INSERT INTO instructions (id, part, instructions) VALUES (20, 'FUEL_INJECTION_SENSOR', 'Have the fuel injection sensor checked by a mechanic.');
INSERT INTO instructions (id, part, instructions) VALUES (21, 'DRAIN_PAN_AC', 'The drain pan of the A/C evaporator unit is not draining. It is best to have an A/C specialist look at this, as the clog may be further up in the system and difficult to access.');







--
-- obd
-- 
INSERT INTO question (id, question) VALUES (5, 'What is your OBD fault code?');
INSERT INTO question (id, question) VALUES (6, 'Does your car ride roughly?');
INSERT INTO question (id, question) VALUES (8, 'Does it leak under your vechicle?');
INSERT INTO question (id, question) VALUES (10, 'Do you rotten eggs/sulphur?');
INSERT INTO question (id, question) VALUES (12, 'Does your PCV valve leak?');

INSERT INTO answer (id, answer_text, follow_up_question_id) VALUES (9, 'P0300', 6);
INSERT INTO answer (id, answer_text, follow_up_question_id) VALUES (18, 'P0440', 8);
INSERT INTO answer (id, answer_text, follow_up_question_id) VALUES (19, 'P0420', 10);
INSERT INTO answer (id, answer_text, follow_up_question_id) VALUES (24, 'P0171', 12);

INSERT INTO question (id, question) VALUES (11, 'Does the vechicle start every time?');
INSERT INTO question (id, question) VALUES (13, 'Is the engine working properly?');

INSERT INTO answer (id, answer_text) VALUES (20, 'Yes');
INSERT INTO answer (id, answer_text, follow_up_question_id) VALUES (21, 'No', 11);
INSERT INTO answer (id, answer_text) VALUES (22, 'Yes');
INSERT INTO answer (id, answer_text) VALUES (23, 'No');
INSERT INTO answer (id, answer_text) VALUES (25, 'Yes');
INSERT INTO answer (id, answer_text, follow_up_question_id) VALUES (26, 'No', 13);
INSERT INTO answer (id, answer_text) VALUES (27, 'Yes');
INSERT INTO answer (id, answer_text) VALUES (28, 'No');

INSERT INTO question (id, question) VALUES (7, 'Do your spark plugs work?');
INSERT INTO question (id, question) VALUES (9, 'Is your vapor sensor faulty?');
INSERT INTO answer (id, answer_text, follow_up_question_id) VALUES (10, 'Yes', 7);

INSERT INTO answer (id, answer_text, follow_up_question_id) VALUES (15, 'No', 9);
INSERT INTO answer (id, answer_text) VALUES (11, 'Yes'), (12, 'No'), (13, 'No'), (14, 'Yes'), (16, 'Yes'), (17, 'No');

INSERT INTO question_answers (question_id, answers_id) VALUES (5, 9), (5, 18), (6, 10), (6, 13), (7, 11), (7, 12), (8, 14), (8, 15), (9, 16), (9, 17);
INSERT INTO question_answers (question_id, answers_id) VALUES (5, 19), (10, 20), (10, 21), (11, 22), (11, 23);
INSERT INTO question_answers (question_id, answers_id) VALUES (5, 24), (12, 25), (12, 26), (13, 27), (13, 28);

INSERT INTO instructions (id, part, instructions) VALUES (5, 'SPARK_PLUGS', 'Change your spark plugs.');
INSERT INTO instructions (id, part, instructions) VALUES (6, 'RESET_OBD', 'OBD connector made an error. Restart it.');
INSERT INTO instructions (id, part, instructions) VALUES (7, 'FUEL_TANK', 'Your fuel tank is probably leaking. Visit your mechanic.');
INSERT INTO instructions (id, part, instructions) VALUES (8, 'VAPOR_SENSOR', 'Change your vapor sensor.');
INSERT INTO instructions (id, part, instructions) VALUES (9, 'CATALYZER', 'Check if your catalyzer is working properly.');
INSERT INTO instructions (id, part, instructions) VALUES (10, 'FUEL_PUMP', 'Check if your fuel pump is working properly.');
INSERT INTO instructions (id, part, instructions) VALUES (11, 'MAF', 'Your Mass Air Flow sensor is probably faulty.');
INSERT INTO instructions (id, part, instructions) VALUES (12, 'PCV_LEAK', 'Your PCV valve is faulty.');
INSERT INTO instructions (id, part, instructions) VALUES (22, 'MAJOR_SPARK_PLUGS', 'Your spark plugs have broken 3 times already.
                                                Try installing better spark plugs and visit your mechanic if the problem persists.');