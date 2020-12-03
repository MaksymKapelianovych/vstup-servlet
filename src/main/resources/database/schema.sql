DROP TABLE IF EXISTS 'request';
DROP TABLE IF EXISTS 'entrant';
DROP TABLE IF EXISTS 'faculty';
DROP TABLE IF EXISTS 'faculty_requirement'

CREATE TABLE 'entrant'
(
    'id' int(11) NOT NULL AUTO_INCREMENT,
    'firstname' varchar(255) NOT NULL,
    'lastname' varchar(255) NOT NULL,
    'surname' varchar (255) NOT NULL,
    'email' varchar(255) NOT NULL,
    'city' varchar(255) NOT NULL,
    'school' varchar(255) NOT NULL,
    'role' varchar(255) NOT NULL,
    PRIMARY KEY ('id'),
    UNIQUE KEY 'entrant_email' ('email')
);

CREATE TABLE 'faculty_requirement'
(
    'id' int(11) NOT NULL AUTO_INCREMENT,
    'first_name' varchar(255) NOT NULL,
    'first_rate' int(11) NOT NULL,
    'second_name' varchar(255) NOT NULL,
    'second_rate' int(11) NOT NULL,
    'third_name' varchar(255) NOT NULL,
    'third_rate' int(11) NOT NULL,
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
    CONSTRAINT 'fk_requirement_id' FOREIGN KEY ('requirement_id') REFERENCES 'faculty_requirement' ('id') ON DELETE CASCADE ON UPDATE CASCADE
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
    CONSTRAINT 'fk_faculty_id' FOREIGN KEY ('faculty_id') REFERENCES 'faculty' ('id') ON DELETE CASCADE ON UPDATE CASCADE,
);

