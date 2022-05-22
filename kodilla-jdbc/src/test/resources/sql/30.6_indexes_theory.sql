CREATE TABLE PHONES (
                        PHONE_ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        PHONENUM INT(9),
                        FIRSTNAME VARCHAR(50),
                        LASTNAME VARCHAR(50)
);

DELIMITER $$
CREATE PROCEDURE FillTestData()
BEGIN
    DECLARE K INT DEFAULT 0;
    WHILE (K < 100000)
        DO
            INSERT INTO PHONES (PHONENUM,
                                FIRSTNAME,
                                LASTNAME)
            VALUES (ROUND(RAND() * 1000000000),
                    CONCAT('Firstname number ', K),
                    CONCAT('Lastname number ', K));
            IF (MOD(K, 5000) = 0) THEN
                COMMIT;
            END IF;
            SET K = K + 1;
        END WHILE;
    COMMIT;
END $$
DELIMITER ;

CALL FillTestData();

CREATE TABLE PHONESTATS
(
    PHONESTAT_ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    RANGE_FROM    INT(11),
    RANGE_TO      INT(11),
    QUANTITY      INT(11)
);

DELIMITER $$
CREATE PROCEDURE CalcPhoneStats()
BEGIN
    DECLARE K INT(11) DEFAULT 0;
    DECLARE QTY INT(11);
    DELETE FROM PHONESTATS;                                    -- [1]
    COMMIT;
    WHILE (K < 100000000) DO
            SELECT COUNT(*)                                         -- [2]
            FROM PHONES                                         -- [3]
            WHERE PHONENUM BETWEEN K-99999 AND K                    -- [4]
            INTO QTY;                                           -- [5]
            INSERT INTO PHONESTATS (RANGE_FROM, RANGE_TO, QUANTITY) -- [6]
            VALUES (K-99999, K, QTY);                           -- [7]
            COMMIT;
            SET K = K + 100000;                                     -- [8]
        END WHILE;
END $$
DELIMITER ;

CALL CalcPhoneStats();

EXPLAIN  SELECT COUNT(*)
FROM PHONES
WHERE PHONENUM BETWEEN 1 AND 100000;

CREATE INDEX PHONENO ON PHONES (PHONENUM);