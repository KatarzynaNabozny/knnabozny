SET @RENTSQTY = 0;                                 -- [1]

DELIMITER $$
CREATE TRIGGER RENTSCOUNTER BEFORE INSERT ON RENTS -- [2]
    FOR EACH ROW
BEGIN
    SET @RENTSQTY = @RENTSQTY + 1;                  -- [3]
END $$

DELIMITER ;

SELECT @RENTSQTY;

# --------------
INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES(1, 3, DATE_SUB(CURDATE(), INTERVAL 5 DAY), NULL);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES(2, 3, DATE_SUB(CURDATE(), INTERVAL 2 DAY), NULL);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES(3, 1, DATE_SUB(CURDATE(), INTERVAL 5 DAY), NULL);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES(2, 4, DATE_SUB(CURDATE(), INTERVAL 3 DAY), NULL);

COMMIT;
#-----------

DROP TRIGGER RENTSCOUNTER;
#==============================================

CREATE TABLE RENTS_AUD (
                           EVENT_ID INT(11) NOT NULL AUTO_INCREMENT,
                           EVENT_DATE DATETIME NOT NULL,
                           EVENT_TYPE VARCHAR(10) DEFAULT NULL,
                           RENT_ID INT(11) NOT NULL,
                           OLD_BOOK_ID INT(11),
                           NEW_BOOK_ID INT(11),
                           OLD_READER_ID INT(11),
                           NEW_READER_ID INT(11),
                           OLD_RENT_DATE DATETIME,
                           NEW_RENT_DATE DATETIME,
                           OLD_RETURN_DATE DATETIME,
                           NEW_RETURN_DATE DATETIME,
                           PRIMARY KEY (EVENT_ID)
);

#-----------TRIGERS--------------
#INSERT
DELIMITER $$

CREATE TRIGGER RENTS_INSERT AFTER INSERT ON RENTS                                        -- [1]
    FOR EACH ROW
BEGIN
    INSERT INTO RENTS_AUD (EVENT_DATE, EVENT_TYPE, RENT_ID, NEW_BOOK_ID, NEW_READER_ID,   -- [2]
                           NEW_RENT_DATE, NEW_RETURN_DATE)                                -- [3]
        VALUE(CURTIME(), 'INSERT', NEW.RENT_ID, NEW.BOOK_ID, NEW.READER_ID, NEW.RENT_DATE, -- [4]
              NEW.RETURN_DATE);                                                            -- [5]
END $$
DELIMITER ;

#DELETE-----
DELIMITER $$

CREATE TRIGGER RENTS_DELETE AFTER DELETE ON RENTS
    FOR EACH ROW
BEGIN
    INSERT INTO RENTS_AUD (EVENT_DATE, EVENT_TYPE, RENT_ID)
        VALUE(CURTIME(), 'DELETE', OLD.RENT_ID);
END $$
DELIMITER ;

#UPDATE------
DELIMITER $$
CREATE TRIGGER RENTS_UPDATE AFTER UPDATE ON RENTS
    FOR EACH ROW
BEGIN
    INSERT INTO RENTS_AUD (EVENT_DATE, EVENT_TYPE, RENT_ID, NEW_BOOK_ID, NEW_READER_ID,
                           NEW_RENT_DATE, NEW_RETURN_DATE, OLD_BOOK_ID, OLD_READER_ID,
                           OLD_RENT_DATE, OLD_RETURN_DATE)
        VALUE(CURTIME(), 'UPDATE', OLD.RENT_ID, NEW.BOOK_ID, NEW.READER_ID,
              NEW.RENT_DATE, NEW.RETURN_DATE, OLD.BOOK_ID, OLD.READER_ID,
              OLD.RENT_DATE, OLD.RETURN_DATE);
END $$
DELIMITER ;
#-----------------------------

#CHECK--->
INSERT INTO RENTS (BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (2, 4, DATE_SUB(CURDATE(), INTERVAL 5 DAY), NULL);
COMMIT;

DELETE FROM RENTS WHERE RENT_ID = 24;
COMMIT;

UPDATE RENTS SET RETURN_DATE = CURDATE()
WHERE RENT_ID = 15;
COMMIT;