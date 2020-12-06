INSERT INTO subject
VALUES (1, "ENGLISH", 120),
       (2, "MATH", 120),
       (3, "HISTORY", 160),
       (4, "UKRAINIAN", 150),
       (5, "PHYSICS", 120),
       (6, "ENGLISH", 160),
       (7, "MATH", 150),
       (8, "PHYSICS", 165),
       (9, "UKRAINIAN", 150),
       (10, "PHYSICS", 120),
       (11, "ENGLISH", 125),
       (12, "MATH", 167),
       (13, "ENGLISH", 169),
       (14, "UKRAINIAN", 160),
       (15, "PHYSICS", 123);

INSERT INTO statement
VALUES (1, false);

INSERT INTO school
VALUES (1, "School №1", "Kyiv", "KYIV"),
       (2, "School №1", "Brovary", "KYIV"),
       (3, "School №6", "Lviv", "LVIV");

INSERT INTO requirement
VALUES (1, 1, 2, 3, 4, 5),
       (2, 6, 7, 8, 9, null),
       (3, 10, 11, 12, null, null),
       (4, 13, 14, 15, null, null);

INSERT INTO faculty
VALUES (1, "Faculty of computer science and cybernetics", 90, 120, 1),
       (2, "Faculty of Mechanics and Mathematics", 50, 100, 2);

INSERT INTO entrant
VALUES (1, "Maksym Kapelianovych Volodymyrovych", "admin", "vfrc.zomby30@gmail.com", 1, "ADMIN", 3),
       (2, "Ivan Ivanov Ivanovych", "ivan", "ivanivanov@gmail.com", 2, "USER", 4);

INSERT INTO request
VALUES (1, 2, 1, 13, 14, 15, null, "ACTIVE"),
       (2, 2, 2, 13, 14, 15, 1, "ACCEPTED");