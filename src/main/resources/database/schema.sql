DROP TABLE IF EXISTS 'request';
DROP TABLE IF EXISTS 'entrant';
DROP TABLE IF EXISTS 'faculty';
DROP TABLE IF EXISTS 'faculty_requirement';
DROP TABLE IF EXISTS 'school';

CREATE TABLE 'school'
(
    'id' int(11) NOT NULL AUTO_INCREMENT,
    'name' varchar(255) NOT NULL,
    'city' varchar(255) NOT NULL,
    'region' varchar(255) NOT NULL,
    PRIMARY KEY ('id')
);

CREATE TABLE 'entrant'
(
    'id' int(11) NOT NULL AUTO_INCREMENT,
    'fullname' varchar(255) NOT NULL,
    'email' varchar(255) NOT NULL,
    'school_id' varchar(255) DEFAULT NULL,
    'role' varchar(255) NOT NULL,
    PRIMARY KEY ('id'),
    UNIQUE KEY 'entrant_email' ('email'),
    CONSTRAINT 'fk_school_id' FOREIGN KEY ('school_id') REFERENCES 'school' ('id') ON UPDATE CASCADE
);

CREATE TABLE 'faculty_requirement'
(
    'id' int(11) NOT NULL AUTO_INCREMENT,
    'firstSubject' varchar(255) NOT NULL,
    'firstRate' int(11) NOT NULL,
    'secondSubject' varchar(255) NOT NULL,
    'secondRate' int(11) NOT NULL,
    'thirdSubject' varchar(255) NOT NULL,
    'thirdRate' int(11) NOT NULL,
    'fourthSubject' varchar(255) DEFAULT NULL,
    'fourthRate' int(11) DEFAULT NULL,
    'fifthSubject' varchar(255) DEFAULT NULL,
    'fifthRate' int(11) DEFAULT NULL,
    PRIMARY KEY ('id')
);

CREATE TABLE 'faculty'
(
    'id' int(11) NOT NULL AUTO_INCREMENT,
    'name' varchar(255) NOT NULL,
    'maxBudgetPlace' int(11) NOT NULL,
    'maxPlace' int(11) NOT NULL,
    'requirement_id' int(11) NOT NULL,
    PRIMARY KEY ('id'),
    UNIQUE KEY 'faculty_name' ('name'),
    UNIQUE KEY 'faculty_requirement_id_fk' ('requirement_id'),
    CONSTRAINT 'fk_requirement_id' FOREIGN KEY ('requirement_id') REFERENCES 'faculty_requirement' ('id') ON UPDATE CASCADE
);

CREATE TABLE 'request'
(
    'id' int(11) NOT NULL AUTO_INCREMENT,
    'entrant_id' int(11) NOT NULL,
    'faculty_id' int(11) NOT NULL,
    'first_rate' int(11) NOT NULL,
    'second_rate' int(11) NOT NULL,
    'third_rate' int(11) NOT NULL,
    PRIMARY KEY ('id'),
    CONSTRAINT 'fk_entrant_id' FOREIGN KEY ('entrant_id') REFERENCES 'entrant' ('id') ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT 'fk_faculty_id' FOREIGN KEY ('faculty_id') REFERENCES 'faculty' ('id') ON DELETE CASCADE ON UPDATE CASCADE
);

