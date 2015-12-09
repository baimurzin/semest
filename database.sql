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


insert into EVENTS (DATE, EVENT_NAME) values ('1989-02-13', 'tellus in sagittis dui vel');
insert into EVENTS (DATE, EVENT_NAME) values ('1999-06-07', 'vestibulum sagittis sapien cum');
insert into EVENTS (DATE, EVENT_NAME) values ('1995-02-22', 'felis sed lacus morbi');
insert into EVENTS (DATE, EVENT_NAME) values ('2013-11-21', 'luctus et ultrices posuere cubilia curae');
insert into EVENTS (DATE, EVENT_NAME) values ('1989-05-21', 'nisl venenatis lacinia');
insert into EVENTS (DATE, EVENT_NAME) values ('1984-12-30', 'non lectus aliquam sit');
insert into EVENTS (DATE, EVENT_NAME) values ('1974-04-27', 'arcu adipiscing molestie hendrerit');
insert into EVENTS (DATE, EVENT_NAME) values ('1979-01-18', 'nibh fusce lacus purus');
insert into EVENTS (DATE, EVENT_NAME) values ('1977-05-25', 'vestibulum proin eu mi nulla ac');
insert into EVENTS (DATE, EVENT_NAME) values ('1998-05-31', 'eleifend luctus ultricies eu nibh');
insert into EVENTS (DATE, EVENT_NAME) values ('1980-01-10', 'lectus suspendisse potenti');
insert into EVENTS (DATE, EVENT_NAME) values ('1998-03-17', 'interdum eu tincidunt');
insert into EVENTS (DATE, EVENT_NAME) values ('1983-04-14', 'posuere cubilia curae');
insert into EVENTS (DATE, EVENT_NAME) values ('1980-11-24', 'erat vestibulum sed magna');
insert into EVENTS (DATE, EVENT_NAME) values ('2015-11-29', 'dictumst etiam faucibus');
insert into EVENTS (DATE, EVENT_NAME) values ('1987-10-21', 'dolor quis odio consequat varius integer');
insert into EVENTS (DATE, EVENT_NAME) values ('1998-01-07', 'duis bibendum felis sed interdum');
insert into EVENTS (DATE, EVENT_NAME) values ('1979-03-20', 'suspendisse ornare consequat lectus');
insert into EVENTS (DATE, EVENT_NAME) values ('1980-09-08', 'rhoncus sed vestibulum sit amet');
insert into EVENTS (DATE, EVENT_NAME) values ('1973-09-09', 'justo pellentesque viverra');
insert into EVENTS (DATE, EVENT_NAME) values ('1997-09-14', 'erat quisque erat eros viverra eget');
insert into EVENTS (DATE, EVENT_NAME) values ('2007-10-27', 'amet consectetuer adipiscing elit proin interdum');
insert into EVENTS (DATE, EVENT_NAME) values ('1972-11-09', 'vestibulum ante ipsum primis');
insert into EVENTS (DATE, EVENT_NAME) values ('2011-12-07', 'ligula vehicula consequat morbi a');
insert into EVENTS (DATE, EVENT_NAME) values ('2008-01-06', 'velit donec diam neque vestibulum eget');
insert into EVENTS (DATE, EVENT_NAME) values ('1981-12-06', 'vel pede morbi porttitor');
insert into EVENTS (DATE, EVENT_NAME) values ('2005-01-24', 'viverra pede ac diam cras pellentesque');
insert into EVENTS (DATE, EVENT_NAME) values ('1980-08-13', 'at velit eu est');
insert into EVENTS (DATE, EVENT_NAME) values ('2011-10-31', 'sit amet nunc viverra dapibus');
insert into EVENTS (DATE, EVENT_NAME) values ('1984-07-06', 'accumsan tortor quis turpis sed');