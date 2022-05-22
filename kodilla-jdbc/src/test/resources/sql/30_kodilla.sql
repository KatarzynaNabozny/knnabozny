set global log_bin_trust_function_creators=1;
CREATE TABLE BOOKS (
                       BOOK_ID int(11) NOT NULL AUTO_INCREMENT,
                       TITLE varchar(255) NOT NULL,
                       PUBYEAR int(4) NOT NULL,
                       PRIMARY KEY (BOOK_ID)
);

CREATE TABLE READERS (
                         READER_ID int(11) NOT NULL AUTO_INCREMENT,
                         FIRSTNAME varchar(255) NOT NULL,
                         LASTNAME varchar(255) NOT NULL,
                         PESEL_ID varchar(11) NOT NULL,
                         PRIMARY KEY (READER_ID)
);
CREATE TABLE RENTS (
                       RENT_ID int(11) NOT NULL AUTO_INCREMENT,
                       BOOK_ID int(11) NOT NULL,
                       READER_ID int(11) NOT NULL,
                       RENT_DATE datetime NOT NULL,
                       RETURN_DATE datetime,
                       PRIMARY KEY (RENT_ID),
                       FOREIGN KEY (BOOK_ID) REFERENCES BOOKS(BOOK_ID),
                       FOREIGN KEY (READER_ID) REFERENCES READERS(READER_ID)
);
INSERT INTO READERS(FIRSTNAME, LASTNAME, PESEL_ID)
VALUES ('John', 'Smith', '83012217938');

INSERT INTO READERS(FIRSTNAME, LASTNAME, PESEL_ID)
VALUES ('Curtis', 'Wilson', '75121002790');

INSERT INTO READERS(FIRSTNAME, LASTNAME, PESEL_ID)
VALUES ('Cathy', 'Booker', '90112801727');

INSERT INTO READERS(FIRSTNAME, LASTNAME, PESEL_ID)
VALUES ('Marissa', 'Cain', '84061908044');

INSERT INTO READERS(FIRSTNAME, LASTNAME, PESEL_ID)
VALUES ('Muriel', 'Fulton', '76081409269');

COMMIT;

INSERT INTO BOOKS(TITLE, PUBYEAR)
VALUES ('The Stranger', 1942);

INSERT INTO BOOKS(TITLE, PUBYEAR)
VALUES ('In Search of Lost Time', 1927);

INSERT INTO BOOKS(TITLE, PUBYEAR)
VALUES ('The Trial', 1925);

INSERT INTO BOOKS(TITLE, PUBYEAR)
VALUES ('The Little Prince', 1943);

INSERT INTO BOOKS(TITLE, PUBYEAR)
VALUES ('Man\'s Fate', 1933);

COMMIT;

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (1, 1, DATE_SUB(CURDATE(), INTERVAL 10 DAY), null);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (2, 1, DATE_SUB(CURDATE(), INTERVAL 10 DAY), null);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (4, 1, DATE_SUB(CURDATE(), INTERVAL 10 DAY), DATE_SUB(CURDATE(), INTERVAL 5 DAY));

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (1, 3, DATE_SUB(CURDATE(), INTERVAL 8 DAY), null);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (5, 3, DATE_SUB(CURDATE(), INTERVAL 4 DAY), DATE_SUB(CURDATE(), INTERVAL 2 DAY));

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (5, 4, DATE_SUB(CURDATE(), INTERVAL 10 DAY), DATE_SUB(CURDATE(), INTERVAL 8 DAY));

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (5, 5, DATE_SUB(CURDATE(), INTERVAL 8 DAY), null);

COMMIT;

DELIMITER $$

CREATE PROCEDURE ListBooks()
BEGIN
    SELECT * FROM BOOKS;
END $$

DELIMITER ;
CALL ListBooks();

DROP FUNCTION IF EXISTS VipLevel;

DELIMITER $$

CREATE FUNCTION VipLevel() RETURNS VARCHAR(20) DETERMINISTIC
BEGIN
    RETURN 'Standard customer';
END $$

DELIMITER ;

SELECT VipLevel() AS LEVEL;
DROP FUNCTION IF EXISTS VipLevel;

DELIMITER $$

CREATE FUNCTION VipLevel() RETURNS VARCHAR(20) DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(20) DEFAULT 'Standard customer';  -- [1]
    RETURN result;  -- [2]
END $$

DELIMITER ;

SELECT VipLevel() AS LEVEL;
DROP FUNCTION IF EXISTS VipLevel;

DELIMITER $$

CREATE FUNCTION VipLevel(booksrented INT) RETURNS VARCHAR(20) DETERMINISTIC -- [1]
BEGIN									                                    -- [2]
DECLARE result VARCHAR(20) DEFAULT 'Standard customer';	                -- [3]
IF booksrented >= 10 THEN						                        -- [4]
    SET result = 'Gold customer';					                        -- [5]
ELSEIF booksrented >= 5 AND booksrented < 10 THEN			            -- [6]
    SET result = 'Silver customer';				                        -- [7]
ELSEIF booksrented >= 2 AND booksrented < 5 THEN			            -- [8]
    SET result = 'Bronze customer';		           		                -- [9]
ELSE				      					                                -- [10]
    SET result = 'Standard customer';				                        -- [11]
END IF;				    				                                -- [12]
RETURN result;
END $$

DELIMITER ;

SELECT VipLevel(12) AS LEVEL;
DROP FUNCTION IF EXISTS VipLevel;

DELIMITER $$

CREATE PROCEDURE ListUsers()
BEGIN
    SELECT * FROM USERS;
END $$

DELIMITER ;
CALL ListUsers(2);
DROP PROCEDURE IF EXISTS ListUsers;
DELIMITER $$
CREATE PROCEDURE ListUsers(usersId INT)
BEGIN
DECLARE result VARCHAR(20);
IF usersId <0 THEN
    SET result = 'Incorrect Id';
ELSEIF usersId =0 THEN
    SET result = 'Incorrect Id';
ELSE
    SET result = 'Correct Id';
END IF;
END $$
DELIMITER ;
CALL ListUsers(1);

DROP PROCEDURE IF EXISTS ListUsers;
DELIMITER $$
CREATE PROCEDURE ListUsers(usersId INT)
BEGIN
    DECLARE result VARCHAR(20);
    IF usersId <=0 THEN
        SET result = 'Incorrect Id';
    ELSEIF usersId >0 THEN
        SELECT *FROM USERS where ID=usersId;
    END IF;
END $$
DELIMITER ;
CALL ListUsers(1);
ALTER TABLE READERS ADD VIP_LEVEL VARCHAR(20);
DROP PROCEDURE IF EXISTS ListUsers;

DROP PROCEDURE IF EXISTS UpdateVipLevels;
DELIMITER $$
CREATE PROCEDURE UpdateVipLevels()
BEGIN
    DECLARE BOOKSREAD INT;

    SELECT COUNT(*) FROM RENTS
    WHERE READER_ID = 3
    INTO BOOKSREAD;

    SELECT BOOKSREAD;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS UpdateVipLevels;

DELIMITER $$

CREATE PROCEDURE UpdateVipLevels()
BEGIN
    DECLARE BOOKSREAD, DAYS, RDR_ID INT;				 -- [1]
    DECLARE BOOKSPERMONTH DECIMAL(5,2);				 -- [2]
    DECLARE FINISHED INT DEFAULT 0;			   	     -- [3]
    DECLARE ALL_READERS CURSOR FOR SELECT READER_ID FROM READERS;        -- [4]
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET FINISHED = 1;	            -- [5]
    OPEN ALL_READERS;			   		         	 -- [6]
    WHILE (FINISHED = 0) DO			   		         -- [7]
    FETCH ALL_READERS INTO RDR_ID;			   	 -- [8]
    IF (FINISHED = 0) THEN			   		     -- [9]
        SELECT COUNT(*) FROM RENTS			   	     -- [10]
        WHERE READER_ID = RDR_ID			     -- [11]
        INTO BOOKSREAD;			   		     -- [12]

        SELECT DATEDIFF(MAX(RENT_DATE), MIN(RENT_DATE)) + 1 FROM RENTS -- [13]
        WHERE READER_ID = RDR_ID                           		    -- [14]
        INTO DAYS;                                       	    -- [15]

        SET BOOKSPERMONTH = BOOKSREAD / DAYS * 30;              	    -- [16]

        UPDATE READERS SET VIP_LEVEL = VipLevel(BOOKSPERMONTH)		    -- [17]
        WHERE READER_ID = RDR_ID;			   		                -- [18]
        COMMIT;			   				                            -- [19]
    END IF;			   					                            -- [20]
        END WHILE;			   					                            -- [21]

    CLOSE ALL_READERS;   			   			                        -- [22]
END $$

DELIMITER ;
CALL UpdateVipLevels();

DROP PROCEDURE IF EXISTS UpdateVipLevels;
DELIMITER $$

CREATE PROCEDURE UpdateVipLevels()
BEGIN
    DECLARE BOOKSREAD INT;
    DECLARE DAYS INT;

    SELECT COUNT(*) FROM RENTS
    WHERE READER_ID = 3
    INTO BOOKSREAD;

    SELECT DATEDIFF(MAX(RENT_DATE), MIN(RENT_DATE)) + 1 FROM RENTS -- [1]
    WHERE READER_ID = 3	                                  -- [2]
    INTO DAYS;                                           -- [3]

    SELECT BOOKSREAD, DAYS;                                    -- [4]
END $$

DELIMITER ;
DROP PROCEDURE IF EXISTS ListUsers;
DELIMITER $$
CREATE PROCEDURE ListUsers(usersId INT)
BEGIN
    DECLARE result VARCHAR(20);
    IF usersId <=0 THEN
        SET result = 'Incorrect Id';
    ELSEIF usersId >0 THEN
        SELECT *FROM USERS where ID=usersId;
    END IF;
END $$
DELIMITER ;
CALL ListUsers(2);

DROP PROCEDURE IF EXISTS UpdateVipLevels;

DELIMITER $$

CREATE PROCEDURE UpdateVipLevels()
BEGIN
    DECLARE BOOKSREAD, DAYS, RDR_ID INT;				 -- [1]
    DECLARE BOOKSPERMONTH DECIMAL(5,2);				 -- [2]
    DECLARE FINISHED INT DEFAULT 0;			   	     -- [3]
    DECLARE ALL_READERS CURSOR FOR SELECT READER_ID FROM READERS;        -- [4]
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET FINISHED = 1;	            -- [5]
    OPEN ALL_READERS;			   		         	 -- [6]
    WHILE (FINISHED = 0) DO			   		         -- [7]
    FETCH ALL_READERS INTO RDR_ID;			   	 -- [8]
    IF (FINISHED = 0) THEN			   		     -- [9]
        SELECT COUNT(*) FROM RENTS			   	     -- [10]
        WHERE READER_ID = RDR_ID			     -- [11]
        INTO BOOKSREAD;			   		     -- [12]

        SELECT DATEDIFF(MAX(RENT_DATE), MIN(RENT_DATE)) + 1 FROM RENTS -- [13]
        WHERE READER_ID = RDR_ID                           		    -- [14]
        INTO DAYS;                                       	    -- [15]

        SET BOOKSPERMONTH = BOOKSREAD / DAYS * 30;              	    -- [16]

        UPDATE READERS SET VIP_LEVEL = VipLevel(BOOKSPERMONTH)		    -- [17]
        WHERE READER_ID = RDR_ID;			   		                -- [18]
        COMMIT;			   				                            -- [19]
    END IF;			   					                            -- [20]
        END WHILE;			   					                            -- [21]

    CLOSE ALL_READERS;   			   			                        -- [22]
END $$

DELIMITER ;
CALL UpdateVipLevels();
SELECT *FROM READERS;

DELIMITER $$
CREATE PROCEDURE UpdateBestSellers()
BEGIN
        DECLARE BOOKSRENT INT;
        SELECT COUNT(*) FROM RENTS
        WHERE BOOK_ID = 3
        INTO BOOKSRENT;

        SELECT BOOKSRENT;
END $$
DELIMITER ;
CALL UpdateBestSellers();

DROP PROCEDURE if exists UpdateBestSellers;
DELIMITER $$
CREATE PROCEDURE UpdateBestSellers()
BEGIN
    DECLARE BK_ID, BOOK_MONTH_RENTS INT;
    DECLARE ENDDATE DATE;
    DECLARE FINISHED INT DEFAULT 0;

    DECLARE ALL_BOOKS CURSOR FOR SELECT BOOK_ID FROM BOOKS;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET FINISHED = 1;

    SET ENDDATE = DATE_SUB(CURDATE(),INTERVAL 30 DAY );

    OPEN ALL_BOOKS;
    WHILE (FINISHED = 0) DO
            FETCH ALL_BOOKS INTO BK_ID;
            IF (FINISHED = 0) THEN

                SELECT COUNT(*) FROM RENTS
                WHERE RENT_DATE > ENDDATE
                  AND BOOK_ID = BK_ID
                INTO BOOK_MONTH_RENTS;

                IF (BOOK_MONTH_RENTS > 1) THEN
                    UPDATE BOOKS SET BESTSELLERS = TRUE
                    WHERE BOOK_ID = BK_ID;
                    COMMIT;
                ELSE
                    UPDATE BOOKS SET BESTSELLERS = FALSE
                    WHERE BOOK_ID = BK_ID;
                    COMMIT;
                END IF;
            END IF;
        END WHILE;
    CLOSE ALL_BOOKS;
END $$
DELIMITER ;
CALL UpdateBestSellers();