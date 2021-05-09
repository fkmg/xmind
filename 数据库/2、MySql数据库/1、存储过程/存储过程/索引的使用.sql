-- 添加唯一索引
ALTER TABLE book ADD UNIQUE(bname);


SELECT * FROM book WHERE bname='笑傲江湖' AND price = 900;
ALTER TABLE book ADD INDEX bname_price(bname,price);
-- 删除索引
DROP INDEX bname_price ON book;