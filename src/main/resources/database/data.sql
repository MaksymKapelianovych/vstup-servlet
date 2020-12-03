INSERT INTo 'faculty_requirement'
VALUES (1, "Ukrainian", 130, "Math", 150, "English", 150),
       (2, "Ukrainian", 120, "Math", 160, "Physics", 160),
       (3, "Ukrainian", 120, "Math", 160, "Physics", 150);

INSERT INTO 'faculty'
VALUES (1, "Faculty of computer science and cybernetics", 90, 120, 1),
       (2, "Faculty of Mechanics and Mathematics", 50, 100, 2),
       (3, "Faculty of economics", 30, 80, 3);

INSERT INTO 'entrant'
VALUES (1, "Maksym", "Kapelianovych", "Volodymyrovych", "vfrc.zomby30@gmail.com", "Kyiv", "School №1", "ADMIN"),
       (2, "Ivan", "Ivanov", "Ivanovych", "ivanivanov@gmail.com", "Lviv", "School №2", "USER"),
       (3, "Petro", "Petrov", "Petrovych", "petro123@gmail.com", "Odesa", "School №6", "USER");

INSERT INTO 'request'
VALUES (1, 2, 1, 150, 167, 172),
       (2, 2, 3, 167, 199, 161),
       (3, 3, 1, 134, 178, 189),
       (3, 3, 2, 189, 200, 198);