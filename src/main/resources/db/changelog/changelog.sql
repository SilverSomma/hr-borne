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

--changeset hrborne:180720221436

INSERT INTO absence_types VALUES ('58fce113-5110-437c-b548-0750b01836f4','vacation');
INSERT INTO absence_types VALUES ('4a92df85-a32d-44a1-bea0-e308bf13e2d8','child vacation');
INSERT INTO absence_types VALUES ('5e536974-54be-45fa-845f-33f38be7023a','maternity leave');
INSERT INTO absence_types VALUES ('b680108f-988d-4bcd-b2e5-33d91b84d0c0','sickness');
INSERT INTO absence_types VALUES ('28d1111a-e42c-418f-9253-3c509839ce3c','home office');
INSERT INTO absence_types VALUES ('563b6b99-a251-427b-924b-3f661efa7643','training/conference');
INSERT INTO absence_types VALUES ('1d43f346-1876-4686-8d0c-6dc486066c5e','unpaid vacation');
INSERT INTO absence_types VALUES ('3c2a091d-b945-426c-8a48-9926efd0090c','child care leave');
INSERT INTO absence_types VALUES ('87d8bd05-3d6d-4da4-9fdb-2af02fd18a24','studly leave');
INSERT INTO absence_types VALUES ('b8f0357a-da3c-4ef4-b19b-8b2f046a5a59','business trip');
INSERT INTO absence_types VALUES ('bd8761ee-f9b2-4479-a413-a40ba29e2de0','care leave');

--changeset hrborne:180720221444

INSERT INTO users VALUES (
                          '3488884c-120b-4542-8179-4d0c7194f24c',
                          'Kristjan',
                          'Mand',
                          '08-10-1999',
                          'kristjan@codeborne.com',
                          '07-07-2022',
                          null,
                          true,
                          false
                         );

INSERT INTO users VALUES (
                          'a1f35c5b-63bf-429d-a9f2-8aafc677e276',
                          'Silver',
                          'Somma',
                          '10-08-1997',
                          'silver@codeborne.com',
                          '06-06-2022',
                          '12-12-2022',
                          true,
                          true
                         );

INSERT INTO users VALUES (
                          '4d5107b0-755c-4750-97df-112eac0d0ff1',
                          'Jaan',
                          'Murk',
                          '12-05-1982',
                          'jaan@codeborne.com',
                          '01-01-2022',
                          '06-06-2022',
                          true,
                          true
                         );

--changeset hrborne:180720221616

INSERT INTO absences VALUES (
                             'd62ac15e-c96b-4309-b88e-a1841d5a372f',
                             '3488884c-120b-4542-8179-4d0c7194f24c',
                             '28d1111a-e42c-418f-9253-3c509839ce3c',
                             '07-17-2022',
                             '07-20-2022',
                             'Tootan kodus'
                            )

