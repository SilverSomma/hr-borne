--liquibase formatted sql
--changeset hrborne:180720221339

CREATE TABLE users
(
    id UUID PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL ,
    last_name VARCHAR(50) NOT NULL ,
    birth_date DATE NOT NULL ,
    email VARCHAR(50) NOT NULL,
    work_start DATE NOT NULL,
    work_end DATE,
    logs_hours BOOLEAN DEFAULT TRUE,
    is_admin BOOLEAN DEFAULT FALSE
);

--changeset hrborne:180720221404

CREATE TABLE absence_types
(
    id UUID PRIMARY KEY,
    absence_type VARCHAR(50) NOT NULL,
    description VARCHAR(255)
);

CREATE TABLE absences
(
    id UUID PRIMARY KEY,
    user_id UUID REFERENCES users(id),
    absence_type_id UUID REFERENCES absence_types(id),
    absence_start DATE NOT NULL,
    absence_end DATE NOT NULL,
    description VARCHAR(255)
);

