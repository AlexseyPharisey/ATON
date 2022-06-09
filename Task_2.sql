CREATE TABLE tblClosePrice (
`PriceDate` date not null,
`PriceAssetId` int not null,
`ClosePrice` numeric (19,8) not null
);
INSERT INTO tblClosePrice (`PriceDate`, `PriceAssetId`, `ClosePrice`)
VALUES ("2020.01.20", 1, 10000),
 ("2021.01.21", 2, 15000),
 ("2022.01.22", 3, 100000),
 ("2022.02.10", 4, 35000),
 ("2021.02.11", 5, 50000),
 ("2022.02.12", 6, 15000000),
 ("2021.03.05", 7, 150),
 ("2021.03.06", 8, 43750),
 ("2022.03.07", 9, 24900),
 ("2020.04.30", 10, 45780);

SELECT * FROM tblClosePrice
WHERE `ClosePrice` = (SELECT MAX(`ClosePrice`) FROM tblClosePrice
 WHERE YEAR(`PriceDate`) = '2021');

SELECT * FROM tblClosePrice
WHERE `ClosePrice` = (SELECT MIN(`ClosePrice`) FROM tblClosePrice
 WHERE YEAR(`PriceDate`) = '2021');

SELECT * FROM tblClosePrice
WHERE `ClosePrice` = (SELECT MAX(`ClosePrice`) FROM tblClosePrice
 WHERE YEAR(`PriceDate`) = '2021' AND MONTH(`PriceDate`) = '01');

SELECT * FROM tblClosePrice
WHERE `ClosePrice` = (SELECT MIN(`ClosePrice`) FROM tblClosePrice
 WHERE YEAR(`PriceDate`) = '2021' AND MONTH(`PriceDate`) = '01');