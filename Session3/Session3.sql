-- INDEX
CREATE INDEX IDX_CUS_PHONE ON Customers (Phone);
CREATE INDEX IDX_CUS_EMAIL_PHONE ON Customers (Email, Phone);
select * from Customers where phone like '555%' and Email like 'charlie@example.com';
-- STORE PROCEDURE
DELIMITER //
CREATE PROCEDURE SP_SEARCH_REPORT_RATE(IN RATE float, OUT OUT_PARAM varchar(50))
BEGIN
	-- 7. Tìm kiếm sản phẩm dựa trên mức đánh giá trung bình
    SET OUT_PARAM = 'Value';
	select 
		P.ProductName as 'Tên SP',
		avg(Rating) as 'Điểm TB'
	From 
		products P
	Join reviews R on R.ProductID = P.ProductID
	group by P.ProductName
	having avg(R.Rating) >= RATE;
END;
//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE SP_SEARCH_REPORT_RATE1(IN RATE float, OUT OUT_PARAM varchar(50))
BEGIN
	-- 7. Tìm kiếm sản phẩm dựa trên mức đánh giá trung bình
    SET OUT_PARAM = 'Value';
	select 
		P.ProductName as 'Tên SP',
		avg(Rating) as 'Điểm TB'
	From 
		products P
	Join reviews R on R.ProductID = P.ProductID
	group by P.ProductName
	having avg(R.Rating) >= RATE;
END;
//
DELIMITER ;

DROP PROCEDURE SP_SEARCH_REPORT_RATE;
DROP PROCEDURE SP_SEARCH_REPORT_RATE1;
call SP_SEARCH_REPORT_RATE(4, @out_value);
select @out_value;


-- VIEW
CREATE VIEW VW_REPORT_PRODUCT_SELL
AS
	select c.CategoryName, sum(od.Quantity) as tongsanphamdaban
	from Categories c
	inner join Products p on c.CategoryID = p.CategoryID
	inner join OrderDetails od on p.ProductID = od.ProductID
	group by c.CategoryName;
    
    
select * from VW_REPORT_PRODUCT_SELL;


-- Tạo index cho các bảng Products, Customers, Orders phù hợp với mục đích truy vấn
-- Tạo thủ tục
	-- 6. Liệt lấy ra n sản phẩm được đặt hàng nhiều nhất
    -- 7. Tìm kiếm sản phẩm dựa trên mức đánh giá trung bình
    -- 9. Tổng doanh thu từng tháng trong của năm x (x là tham số in của thủ tục)
    -- 10. Insert dữ liệu vào bảng order, trả về id của order vừa được insert.
    
-- Tạo VIEW
	-- 2. Báo cáo số lượng sản phẩm đã bán theo danh mục
	-- 3. Báo cáo danh sách khách hàng và số lượng đơn hàng mỗi khách hàng đã đặt
	-- 4. Báo cáo tỷ lệ đơn hàng đã giao thành công
