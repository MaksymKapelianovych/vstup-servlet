DROP TABLE IF EXISTS request;
DROP TABLE IF EXISTS entrant;
DROP TABLE IF EXISTS faculty;
DROP TABLE IF EXISTS requirement;
DROP TABLE IF EXISTS school;
DROP TABLE IF EXISTS statement;
DROP TABLE IF EXISTS subject;

CREATE TABLE subject
(
    id int(11) NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    rate int(11) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE statement
(
    id int(11) NOT NULL AUTO_INCREMENT,
    finalized boolean NOT NULL DEFAULT FALSE,
    PRIMARY KEY (id)
);

CREATE TABLE school
(
    id int(11) NOT NULL AUTO_INCREMENT,
    name_en varchar(255) NOT NULL,
    name_ua varchar(255) NOT NULL,
    city_en varchar(255) NOT NULL,
    city_ua varchar(255) NOT NULL,
    region varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE requirement
(
    id int(11) NOT NULL AUTO_INCREMENT,
    first_subject_id int(11) NOT NULL UNIQUE,
    second_subject_id int(11) NOT NULL UNIQUE,
    third_subject_id int(11) NOT NULL UNIQUE,
    fourth_subject_id int(11) DEFAULT NULL UNIQUE,
    fifth_subject_id int(11) DEFAULT NULL UNIQUE,
    CONSTRAINT requirement_fk1_subject_id FOREIGN KEY (first_subject_id) REFERENCES subject (id) ON UPDATE CASCADE,
    CONSTRAINT requirement_fk2_subject_id FOREIGN KEY (second_subject_id) REFERENCES subject (id) ON UPDATE CASCADE,
    CONSTRAINT requirement_fk3_subject_id FOREIGN KEY (third_subject_id) REFERENCES subject (id) ON UPDATE CASCADE,
    CONSTRAINT requirement_fk4_subject_id FOREIGN KEY (fourth_subject_id) REFERENCES subject (id) ON UPDATE CASCADE,
    CONSTRAINT requirement_fk5_subject_id FOREIGN KEY (fifth_subject_id) REFERENCES subject (id) ON UPDATE CASCADE,
    PRIMARY KEY (id)
);


CREATE TABLE entrant
(
    id int(11) NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    email varchar(255) NOT NULL UNIQUE,
    school_id int(11) DEFAULT NULL,
    role varchar(255) NOT NULL,
    requirement_id int(11) NOT NULL UNIQUE,
    active boolean DEFAULT TRUE,
    PRIMARY KEY (id),
    CONSTRAINT entrant_fk_school_id FOREIGN KEY (school_id) REFERENCES school (id) ON UPDATE CASCADE,
    CONSTRAINT entrant_fk_requirement_id FOREIGN KEY (requirement_id) REFERENCES requirement (id) ON UPDATE CASCADE
);

CREATE TABLE faculty
(
    id int(11) NOT NULL AUTO_INCREMENT,
    name_en varchar(255) NOT NULL UNIQUE,
    name_ua varchar(255) NOT NULL UNIQUE,
    maxBudgetPlace int(11) NOT NULL,
    maxPlace int(11) NOT NULL,
    requirement_id int(11) NOT NULL UNIQUE,
    active boolean DEFAULT TRUE,
    PRIMARY KEY (id),
    CONSTRAINT faculty_fk_requirement_id FOREIGN KEY (requirement_id) REFERENCES requirement (id) ON UPDATE CASCADE
);

CREATE TABLE request
(
    id int(11) NOT NULL AUTO_INCREMENT,
    entrant_id int(11) NOT NULL,
    faculty_id int(11) NOT NULL,
    first_subject_id int(11) NOT NULL,
    second_subject_id int(11) NOT NULL,
    third_subject_id int(11) NOT NULL,
    statement_id int(11) DEFAULT NULL,
    priority int(1) NOT NULL,
    state varchar(255) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT request_fk_entrant_id FOREIGN KEY (entrant_id) REFERENCES entrant (id) ON UPDATE CASCADE,
    CONSTRAINT request_fk_faculty_id FOREIGN KEY (faculty_id) REFERENCES faculty (id) ON UPDATE CASCADE,
    CONSTRAINT request_fk_statement_id FOREIGN KEY (statement_id) REFERENCES statement (id) ON UPDATE CASCADE
);

