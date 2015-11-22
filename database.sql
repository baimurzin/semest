CREATE TABLE PUBLIC.USERS
(
    LOGIN VARCHAR(120) PRIMARY KEY NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    COUNTRY VARCHAR(122),
    EMAIL VARCHAR(120) NOT NULL,
    BIRTH_DATE DATE
);
ALTER TABLE PUBLIC.USERS ADD CONSTRAINT unique_LOGIN UNIQUE (LOGIN);
ALTER TABLE PUBLIC.USERS ADD CONSTRAINT unique_EMAIL UNIQUE (EMAIL);


CREATE TABLE PUBLIC.EVENTS
(
    ID INT AUTO_INCREMENT NOT NULL,
    DATE DATE NOT NULL,
    EVENT_NAME VARCHAR(122) NOT NULL
);