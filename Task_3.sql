CREATE TABLE tblClient (
`ClientId` INT PRIMARY KEY NOT NULL,
`Name` VARCHAR(60)
);
CREATE TABLE tblClientPayments (
`ClientId` INT NOT NULL,
`PaymentDate` DATE NOT NULL,
`PaymentSum` INT,
FOREIGN KEY (`ClientId`) REFERENCES tblClient (`ClientId`)
);
INSERT INTO tblClient (`ClientId`, `Name`)
VALUES (1, "Иванов Иван Иванович"),
 (2, "Петров Петр Петрович"),
 (3, "Кузнецова Анна Андреевна"),
 (4, "Тихонова Светлана Анатольевна");
INSERT INTO tblClientPayments (`ClientId`, `PaymentDate`, `PaymentSum`)
VALUES (1, "2022.02.01", 4000),
 (1, "2022.02.05", 6000),
 (3, "2022.03.02", 10000),
 (3, "2022.03.09", 1000),
 (1, "2022.03.16", 2000);

--1
SELECT tblClient.`ClientId`,`Name`, SUM(`PaymentSum`) FROM tblClient,
tblClientPayments
WHERE tblClient.`ClientId` = tblClientPayments.`ClientId`
GROUP BY tblClient.`ClientId`;

--2
SELECT tblClient.`ClientId`,`Name`, SUM(`PaymentSum`) FROM tblClient,
tblClientPayments
WHERE (tblClient.`ClientId` = tblClientPayments.`ClientId` AND DATE(`PaymentDate`) >
"2022.03.05")
OR (tblClient.`ClientId` = tblClientPayments.`ClientId` AND
((SELECT SUM(`PaymentSum`) FROM tblClientPayments))>7000)
GROUP BY tblClient.`ClientId`;

--3
SELECT tblClient.`ClientId`,`Name`
FROM tblClientPayments, tblClient
WHERE tblClient.`ClientId` = tblClientPayments.`ClientId`
GROUP BY `ClientId`
HAVING COUNT(MONTH(`PaymentDate`)) > 1;

--4
UPDATE tblClientPayments
SET `PaymentSum` = (`PaymentSum` - (`PaymentSum` * 0.1))
WHERE ClientId = 3;

--5
INSERT INTO tblClientPayments (`ClientId`, `PaymentDate`, `PaymentSum`) VALUES (2,
"2022.05.02", 18000);
SELECT * FROM tblClientPayments;