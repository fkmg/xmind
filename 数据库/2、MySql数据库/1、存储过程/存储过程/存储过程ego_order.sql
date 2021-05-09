DELIMITER //
CREATE PROCEDURE odertotaltax(
IN order_num VARCHAR(50),/*订单号*/
IN tax BOOLEAN,/*是否付邮费*/
OUT total DECIMAL(8,3)
)
BEGIN
  DECLARE ordertotal DECIMAL(8,3);/*声明变量:总金额*/
  DECLARE taxvalue FLOAT DEFAULT 20;/*声明变量:邮费*/
  /*计算制定订单的总价*/
  SELECT payment INTO ordertotal FROM tb_order WHERE order_id = order_num;
  IF tax THEN
	SELECT (ordertotal+post_fee) INTO ordertotal FROM tb_order WHERE order_id = order_num;
  END IF;
  SELECT ordertotal INTO total;
END //

DELIMITER;

CALL odertotaltax('371561712611529',TRUE,@total);
SELECT @total;

CALL odertotaltax('371561712611529',FALSE,@total);




