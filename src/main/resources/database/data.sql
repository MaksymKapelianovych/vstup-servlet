INSERT INTO 'school'
VALUES (1, "School №1", "Kyiv", "KYIV"),
       (2, "School №1", "Brovary", "KYIV"),
       (3, "School №6", "Lviv", "LVIV");

INSERT INTO 'faculty_requirement'
VALUES (1, "UKRAINIAN", 130, "MATH", 150, "ENGLISH", 150, "PHYSICS", 150),
       (2, "UKRAINIAN", 120, "MATH", 160, "PHYSICS", 160, "HISTORY", 120),
       (3, "UKRAINIAN", 120, "MATH", 160, "PHYSICS", 150);

INSERT INTO 'faculty'
VALUES (1, "Faculty of computer science and cybernetics", 90, 120, 1),
       (2, "Faculty of Mechanics and Mathematics", 50, 100, 2),
       (3, "Faculty of economics", 30, 80, 3);

INSERT INTO 'entrant'
VALUES (1, "Maksym Kapelianovych Volodymyrovych", "vfrc.zomby30@gmail.com", 1, "ADMIN"),
       (2, "Ivan Ivanov Ivanovych", "ivanivanov@gmail.com", 2, "USER"),
       (3, "Petro Petrov Petrovych", "petro123@gmail.com", 3, "USER");

INSERT INTO 'request'
VALUES (1, 2, 1, 150, 167, 172),
       (2, 2, 3, 167, 199, 161),
       (3, 3, 1, 134, 178, 189),
       (3, 3, 2, 189, 200, 198);