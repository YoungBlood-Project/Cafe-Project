--TABLE ��ȸ
SELECT * FROM Customer;
SELECT * FROM Mileage;
SELECT * FROM MileageHistory;
SELECT * FROM Category;
SELECT * FROM Item;
SELECT * FROM SalesTotalPrice;
SELECT * FROM SalesHistory;

--TABLE ���� --
DROP TABLE Customer;
DROP TABLE Mileage;
DROP TABLE MileageHistory;
DROP TABLE Category;
DROP TABLE Item;
DROP TABLE SalesTotalPrice;
DROP TABLE SalesHistory;


CREATE TABLE Customer(
   cid      BIGINT			PRIMARY KEY GENERATED ALWAYS AS IDENTITY,							--�� PK
   name   	VARCHAR(30) 	NOT NULL,															--�̸�
   phone   	VARCHAR(20)		NOT NULL,                                                           --�޴�����ȣ
   regDate	TIMESTAMP		NOT	NULL	DEFAULT	CURRENT_TIMESTAMP								--��� ��¥
);

CREATE TABLE Mileage(
	mId				BIGINT		PRIMARY	KEY	GENERATED	ALWAYS	AS	IDENTITY,					--�� ���ϸ��� PK	
	customerId		BIGINT		NOT	NULL,														--FK(�� PK)
	mTotal			INT			NOT	NULL	DEFAULT	0,											--�� ���ϸ����ݾ�
	CONSTRAINT	Mileage_customerId_FK	FOREIGN	KEY(customerId)	REFERENCES	Customer(cid)	
);

CREATE TABLE MileageHistory(
	mhId		BIGINT		PRIMARY	KEY	GENERATED ALWAYS AS IDENTITY,							--���ϸ��� PK
	customerId	BIGINT		NOT	NULL,															--FK(�� PK)
	orderNum	BIGINT		NOT	NULL,															--�ֹ� ��ȣ
	mBalance	INT			NOT	NULL	DEFAULT	0,												--���ϸ��� �ܾ�
	regDate		TIMESTAMP	NOT	NULL	DEFAULT	CURRENT_TIMESTAMP,								--���� ��¥
	CONSTRAINT	MileageHistory_customerId_FK	FOREIGN	KEY(customerId)	REFERENCES	Customer(cid)
);

CREATE TABLE Category(
	categoryId		BIGINT		PRIMARY	KEY	GENERATED	ALWAYS	AS	IDENTITY,
	categoryName	VARCHAR(30)	NOT	NULL
);

CREATE TABLE Item(
   itemId      	BIGINT		PRIMARY KEY GENERATED ALWAYS AS IDENTITY,							--�޴� PK
   categoryId	BIGINT		NOT	NULL,															--�޴� ����
   itemName		VARCHAR(30) NOT NULL,															--�޴� �̸�
   itemPrice	INT			NOT NULL,															--�޴� ����
   itemUrl		VARCHAR(100)NOT	NULL	DEFAULT	'http://placehold.it/120x120',
   regDate		TIMESTAMP	NOT	NULL	DEFAULT	CURRENT_TIMESTAMP,
   CONSTRAINT Item_categoryId_FK	FOREIGN	KEY(categoryId)	REFERENCES	Category(categoryId)
);

CREATE TABLE SalesTotalPrice(
	stpId			BIGINT	PRIMARY	KEY	GENERATED	ALWAYS	AS	IDENTITY,
	itemId			BIGINT	NOT	NULL,
	totalPrice		INT		NOT	NULL,
	reducedPrice	INT		NOT	NULL	DEFAULT	0,
	CONSTRAINT	SalesTotalPrice_itemId_FK	FOREIGN	KEY(itemId) REFERENCES	Item(itemId)
);

CREATE TABLE SalesHistory (
	shId		BIGINT		PRIMARY	KEY	GENERATED	ALWAYS	AS	IDENTITY,					--�Ǹų��� PK
	itemId		BIGINT		NOT NULL,															--FK(�޴� PK)
	orderNum	BIGINT		NOT	NULL,															--�ֹ� ��ȣ
	numOfSales	INT			NOT NULL	DEFAULT	0,												--����
	paidPrice	INT			NOT	NULL	DEFAULT	0,												--���� ����
	orderDate	TIMESTAMP	NOT	NULL	DEFAULT	CURRENT_TIMESTAMP,								--�ֹ� ��¥
	CONSTRAINT SalesHistory_itemId_FK FOREIGN KEY(itemId) REFERENCES Item(itemId)
);

--DELETE FROM Item WHERE itemId = 1;
--DELETE FROM SalesHistory WHERE itemId = 2;

ALTER TABLE SalesHistory DROP CONSTRAINT SalesHistory_itemId_FK;
ALTER TABLE SalesHistory ADD CONSTRAINT SalesHistory_itemId_FK FOREIGN KEY(itemId) REFERENCES Item(itemId);