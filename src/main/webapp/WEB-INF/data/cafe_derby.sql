--TABLE 조회
SELECT * FROM Customer;
SELECT * FROM Mileage;
SELECT * FROM MileageHistory;
SELECT * FROM Category;
SELECT * FROM Item;
SELECT * FROM SalesTotalPrice;
SELECT * FROM SalesHistory;

--TABLE 삭제 --
DROP TABLE Customer;
DROP TABLE Mileage;
DROP TABLE MileageHistory;
DROP TABLE Category;
DROP TABLE Item;
DROP TABLE SalesTotalPrice;
DROP TABLE SalesHistory;


CREATE TABLE Customer(
   cid      BIGINT			PRIMARY KEY GENERATED ALWAYS AS IDENTITY,							--고객 PK
   name   	VARCHAR(30) 	NOT NULL,															--이름
   phone   	VARCHAR(20)		NOT NULL,                                                           --휴대폰번호
   regDate	TIMESTAMP		NOT	NULL	DEFAULT	CURRENT_TIMESTAMP								--등록 날짜
);

CREATE TABLE Mileage(
	mId				BIGINT		PRIMARY	KEY	GENERATED	ALWAYS	AS	IDENTITY,					--총 마일리지 PK	
	customerId		BIGINT		NOT	NULL,														--FK(고객 PK)
	mTotal			INT			NOT	NULL	DEFAULT	0,											--총 마일리지금액
	CONSTRAINT	Mileage_customerId_FK	FOREIGN	KEY(customerId)	REFERENCES	Customer(cid)	
);

CREATE TABLE MileageHistory(
	mhId		BIGINT		PRIMARY	KEY	GENERATED ALWAYS AS IDENTITY,							--마일리지 PK
	customerId	BIGINT		NOT	NULL,															--FK(고객 PK)
	orderNum	BIGINT		NOT	NULL,															--주문 번호
	mBalance	INT			NOT	NULL	DEFAULT	0,												--마일리지 잔액
	regDate		TIMESTAMP	NOT	NULL	DEFAULT	CURRENT_TIMESTAMP,								--적립 날짜
	CONSTRAINT	MileageHistory_customerId_FK	FOREIGN	KEY(customerId)	REFERENCES	Customer(cid)
);

CREATE TABLE Category(
	categoryId		BIGINT		PRIMARY	KEY	GENERATED	ALWAYS	AS	IDENTITY,					--카테고리 PK
	categoryName	VARCHAR(30)	NOT	NULL														--카테고리 이름
);

CREATE TABLE Item(
   itemId      	BIGINT		PRIMARY KEY GENERATED ALWAYS AS IDENTITY,							--메뉴 PK
   categoryId	BIGINT		NOT	NULL,															--메뉴 종류
   itemName		VARCHAR(30) NOT NULL,															--메뉴 이름
   itemPrice	INT			NOT NULL,															--메뉴 가격
   itemUrl		VARCHAR(100)NOT	NULL	DEFAULT	'http://placehold.it/120x120',					--이미지 주소
   regDate		TIMESTAMP	NOT	NULL	DEFAULT	CURRENT_TIMESTAMP,								--등록 날짜
   CONSTRAINT Item_categoryId_FK	FOREIGN	KEY(categoryId)	REFERENCES	Category(categoryId)
);

CREATE TABLE SalesTotalPrice(
	stpId			BIGINT	PRIMARY	KEY	GENERATED	ALWAYS	AS	IDENTITY,						--총판매가격 PK
	orderNum	BIGINT		NOT	NULL,															--주문 번호
	totalPrice		INT		NOT	NULL,															--총판매가격
	reducedPrice	INT		NOT	NULL	DEFAULT	0,												--지불 가격(총판매가격 - 마일리지할인가격)
	orderDate	TIMESTAMP	NOT	NULL	DEFAULT	CURRENT_TIMESTAMP								--주문 날짜
);

CREATE TABLE SalesHistory (
	shId		BIGINT		PRIMARY	KEY	GENERATED	ALWAYS	AS	IDENTITY,						--판매내역 PK
	itemId		BIGINT		NOT NULL,															--FK(메뉴 PK)
	orderNum	BIGINT		NOT	NULL,															--주문 번호
	numOfSales	INT			NOT NULL	DEFAULT	0,												--수량
	paidPrice	INT			NOT	NULL	DEFAULT	0,												--지불 가격
	orderDate	TIMESTAMP	NOT	NULL	DEFAULT	CURRENT_TIMESTAMP,								--주문 날짜
	CONSTRAINT SalesHistory_itemId_FK FOREIGN KEY(itemId) REFERENCES Item(itemId)
);

--DELETE FROM Item WHERE itemId = 1;
--DELETE FROM SalesHistory WHERE itemId = 2;

ALTER TABLE SalesHistory DROP CONSTRAINT SalesHistory_itemId_FK;
ALTER TABLE SalesHistory ADD CONSTRAINT SalesHistory_itemId_FK FOREIGN KEY(itemId) REFERENCES Item(itemId);