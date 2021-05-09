-- 1、在单表中添加注释
CREATE VIEW book_view1 AS SELECT bid,bname,author,price,bdate FROM book;
SELECT * FROM book_view1 WHERE bid = 5;
-- 2、创建视图并指定视图字段名
CREATE VIEW book_view2(bname) AS SELECT bname FROM book;
SELECT * FROM book_view2;

--  3、在多表中创建视图
CREATE VIEW product_view1 AS SELECT product.*,brand.`branName` FROM product LEFT JOIN brand ON product.`brandId` = brand.`brandId`;
SELECT * FROM product_view1;

-- 基于同一数据库
CREATE VIEW bd_view1 AS (SELECT * FROM city) UNION ALL(SELECT * FROM county); 
SELECT * FROM bd_view1;

-- 基于不同数据库创建视图
CREATE VIEW test_view1 AS (SELECT * FROM test.`book`) UNION ALL (SELECT * FROM test1.`book`);
SELECT * FROM test_view1;