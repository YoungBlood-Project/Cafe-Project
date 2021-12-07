--TABLE 조회
SELECT * FROM Customer;
SELECT * FROM Mileage;
SELECT * FROM TotalMileage;
SELECT * FROM Menu;
SELECT * FROM SalesHistory;

--TABLE 삭제
DROP TABLE Customer;
DROP TABLE Mileage;
DROP TABLE TotalMileage;
DROP TABLE Menu;
DROP TABLE SalesHistory;

CREATE TABLE Customer(
   cid      BIGINT			PRIMARY KEY GENERATED ALWAYS AS IDENTITY,							--고객 PK
   name   	VARCHAR(30) 	NOT NULL,															--이름
   phone   	VARCHAR(20)		NOT NULL,                                                           	--휴대폰번호
   regDate	TIMESTAMP		NOT	NULL	DEFAULT	CURRENT_TIMESTAMP								--등록 날짜
);

CREATE TABLE Mileage(
	mileageId	BIGINT		PRIMARY	KEY	GENERATED ALWAYS AS IDENTITY,							--마일리지 PK
	customerId	BIGINT		NOT	NULL,															--FK(고객 PK)
	orderNum	BIGINT		NOT	NULL,															--주문 번호
	mBalance	INT			NOT	NULL	DEFAULT	0,												--마일리지 잔액
	regDate		TIMESTAMP	NOT	NULL	DEFAULT	CURRENT_TIMESTAMP,								--적립 날짜
	CONSTRAINT	Mileage_customerId_FK	FOREIGN	KEY(customerId)	REFERENCES	Customer(cid)
);

CREATE TABLE TotalMileage(
	tmId			BIGINT		PRIMARY	KEY	GENERATED	ALWAYS	AS	IDENTITY,					--총 마일리지 PK	
	customerId		BIGINT		NOT	NULL,														--FK(고객 PK)
	mileageTotal	INT			NOT	NULL	DEFAULT	0,											--총 마일리지금액
	CONSTRAINT	TotalMileage_customerId_FK	FOREIGN	KEY(customerId)	REFERENCES	Customer(cid)	
);

CREATE TABLE Menu(
   mid      	BIGINT		PRIMARY KEY GENERATED ALWAYS AS IDENTITY,							--메뉴 PK
   category		VARCHAR(30)	NOT	NULL,															--메뉴 종류
   menuName		VARCHAR(30) NOT NULL,															--메뉴 이름
   menuPrice	INT			NOT NULL													--메뉴 가격
);

CREATE TABLE SalesHistory (
	sid			BIGINT		PRIMARY	KEY	GENERATED	ALWAYS	AS	IDENTITY,						--판매내역 PK
	menuId		BIGINT		NOT NULL,															--FK(메뉴 PK)
	orderNum	BIGINT		NOT	NULL,															--주문 번호
	numOfSales	INT			NOT NULL	DEFAULT	0,												--수량
	paidPrice	INT			NOT	NULL	DEFAULT	0,												--지불 가격
	orderDate	TIMESTAMP	NOT	NULL	DEFAULT	CURRENT_TIMESTAMP,								--주문 날짜
	CONSTRAINT SalesHistory_menuId_FK FOREIGN KEY(menuId) REFERENCES Menu(mid)
);

--DELETE FROM Menu WHERE mid = 3;
--DELETE FROM SalesHistory WHERE menuId = 2;

ALTER TABLE SalesHistory DROP CONSTRAINT SalesHistory_menuId_FK;
ALTER TABLE SalesHistory ADD CONSTRAINT SalesHistory_menuId_FK FOREIGN KEY(menuId) REFERENCES Menu(mid);