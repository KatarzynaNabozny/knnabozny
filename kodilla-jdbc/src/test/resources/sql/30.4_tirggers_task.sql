#AUDIT TABLES----
CREATE TABLE BOOKS_AUD (
                           EVENT_ID INT(11) NOT NULL AUTO_INCREMENT,
                           EVENT_DATE DATETIME NOT NULL,
                           EVENT_TYPE VARCHAR(10) DEFAULT NULL,
                           BOOK_ID INT(11) NOT NULL,
                           OLD_TITLE VARCHAR(255),
                           NEW_TITLE VARCHAR(255),
                           OLD_PUBYEAR INT,
                           NEW_PUBYEAR INT,
                           OLD_BESTSELLERS TINYINT,
                           NEW_BESTSELLERS TINYINT,
                           PRIMARY KEY (EVENT_ID)
);

CREATE TABLE READERS_AUD (
                           EVENT_ID INT(11) NOT NULL AUTO_INCREMENT,
                           EVENT_DATE DATETIME NOT NULL,
                           EVENT_TYPE VARCHAR(10) DEFAULT NULL,
                           READER_ID INT(11) NOT NULL,
                           OLD_FIRSTNAME VARCHAR(255),
                           NEW_FIRSTNAME VARCHAR(255),
                           OLD_LASTNAME VARCHAR(255),
                           NEW_LASTNAME VARCHAR(255),
                           OLD_PESEL_ID VARCHAR(11),
                           NEW_PESEL_ID VARCHAR(11),
                           OLD_VIP_LEVEL VARCHAR(20),
                           NEW_VIP_LEVEL VARCHAR(20),
                           PRIMARY KEY (EVENT_ID)
);
#======================
#TRIGERS---
#BOOKS---->
#INSERT
DELIMITER $$
CREATE TRIGGER BOOKS_INSERT AFTER INSERT ON BOOKS
    FOR EACH ROW
BEGIN
    INSERT INTO BOOKS_AUD (EVENT_DATE, EVENT_TYPE, BOOK_ID, NEW_TITLE, NEW_PUBYEAR, NEW_BESTSELLERS)
        VALUE(CURTIME(), 'INSERT', NEW.BOOK_ID, NEW.TITLE, NEW.PUBYEAR, NEW.BESTSELLERS);
END $$
DELIMITER ;

#DELETE-----
DELIMITER $$
CREATE TRIGGER BOOKS_DELETE AFTER DELETE ON BOOKS
    FOR EACH ROW
BEGIN
    INSERT INTO BOOKS_AUD (EVENT_DATE, EVENT_TYPE, BOOK_ID)
        VALUE(CURTIME(), 'DELETE', OLD.BOOK_ID);
END $$
DELIMITER ;

#UPDATE------
DELIMITER $$
CREATE TRIGGER BOOKS_UPDATE AFTER UPDATE ON BOOKS
    FOR EACH ROW
BEGIN
    INSERT INTO BOOKS_AUD (EVENT_DATE, EVENT_TYPE, BOOK_ID, NEW_TITLE, NEW_PUBYEAR,
                           NEW_BESTSELLERS, OLD_TITLE, OLD_PUBYEAR, OLD_BESTSELLERS)
        VALUE(CURTIME(), 'UPDATE', OLD.BOOK_ID, NEW.TITLE, NEW.PUBYEAR,
              NEW.BESTSELLERS, OLD.TITLE, OLD.PUBYEAR, OLD.BESTSELLERS);
END $$
DELIMITER ;


#READERS----->
#INSERT
DELIMITER $$
CREATE TRIGGER READERS_INSERT AFTER INSERT ON READERS
    FOR EACH ROW
BEGIN
    INSERT INTO READERS_AUD (EVENT_DATE, EVENT_TYPE, READER_ID, NEW_FIRSTNAME, NEW_LASTNAME, NEW_PESEL_ID, NEW_VIP_LEVEL)
        VALUE(CURTIME(), 'INSERT', NEW.READER_ID, NEW.FIRSTNAME, NEW.LASTNAME, NEW.PESEL_ID, NEW.VIP_LEVEL);
END $$
DELIMITER ;

#DELETE-----
DELIMITER $$
CREATE TRIGGER READERS_DELETE AFTER DELETE ON READERS
    FOR EACH ROW
BEGIN
    INSERT INTO READERS_AUD (EVENT_DATE, EVENT_TYPE, READER_ID)
        VALUE(CURTIME(), 'DELETE', OLD.READER_ID);
END $$
DELIMITER ;

#UPDATE------
DELIMITER $$
CREATE TRIGGER READERS_UPDATE AFTER UPDATE ON READERS
    FOR EACH ROW
BEGIN
    INSERT INTO READERS_AUD (EVENT_DATE, EVENT_TYPE, READER_ID, NEW_FIRSTNAME, NEW_LASTNAME,
                             NEW_PESEL_ID, NEW_VIP_LEVEL, OLD_FIRSTNAME, OLD_LASTNAME, OLD_PESEL_ID, OLD_VIP_LEVEL)
        VALUE(CURTIME(), 'UPDATE', OLD.READER_ID, NEW.FIRSTNAME, NEW.LASTNAME,
              NEW.PESEL_ID, NEW.VIP_LEVEL, OLD.FIRSTNAME, OLD.LASTNAME, OLD.PESEL_ID, OLD.VIP_LEVEL);
END $$
DELIMITER ;


#--CHECK--
#--BOOKS
INSERT INTO BOOKS(TITLE, PUBYEAR)
VALUES ('Broken Glass', 2005);

INSERT INTO BOOKS(TITLE, PUBYEAR, BESTSELLERS)
VALUES ('The Girl With the Dragon Tattoo', 2005, 1);

DELETE FROM BOOKS WHERE TITLE = 'Broken Glass';

UPDATE BOOKS SET PUBYEAR ='2006' WHERE TITLE = 'The Girl With the Dragon Tattoo';

#--READERS
INSERT INTO READERS(FIRSTNAME, LASTNAME, PESEL_ID)
VALUES ('Piter', 'Logan', '90112801000');

DELETE FROM READERS WHERE PESEL_ID = '90112801000';

UPDATE READERS SET FIRSTNAME ='Anton' WHERE PESEL_ID = '90112801000';