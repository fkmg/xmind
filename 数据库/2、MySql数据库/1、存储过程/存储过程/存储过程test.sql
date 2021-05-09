DELIMITER //
CREATE PROCEDURE scoreavg()
BEGIN
SELECT AVG(score) AS avgscore FROM student;
END //
DELIMITER;

CALL scoreavg();

/*OUT 代表是返回值参数 sl是变量名称 double是数据类型*/
/*INTO将值付给变量sl*/
DELIMITER //
CREATE PROCEDURE stuscore(
OUT sl DECIMAL(8,2), 
OUT sh DECIMAL(8,2),
OUT sa DECIMAL(8,2)
)
BEGIN
  SELECT MIN(score) INTO sl FROM student;
  SELECT MAX(score) INTO sh FROM student;
  SELECT AVG(score) INTO sa FROM student;
END //
DELIMITER;

CALL stuscore(@slow,@sheight,@savg)
SELECT @slow,@sheight,@savg;

DELIMITER //
CREATE PROCEDURE books(
IN bdates DATE,
OUT totals INT
)
BEGIN
  SELECT COUNT(1) INTO totals FROM book WHERE bdate > bdates;
END //
DELIMITER;


CALL books('2019-04-01',@total)
SELECT @total;












