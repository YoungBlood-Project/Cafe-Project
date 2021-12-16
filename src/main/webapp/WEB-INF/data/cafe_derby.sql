--TABLE ��ȸ
SELECT * FROM Manager;
SELECT * FROM Customer;
SELECT * FROM Mileage;
SELECT * FROM MileageHistory;
SELECT * FROM Category;
SELECT * FROM Item;
SELECT * FROM SalesTotalPrice;
sd
--TABLE ���� --
DROP TABLE Manager;
DROP TABLE Customer;
DROP TABLE Mileage;
DROP TABLE MileageHistory;
DROP TABLE Category;
DROP TABLE Item;
DROP TABLE SalesTotalPrice;
DROP TABLE SalesHistory;

CREATE TABLE Manager (
	managerId		BIGINT 			PRIMARY KEY GENERATED ALWAYS AS IDENTITY,					--�Ŵ��� PK
	managerName   	VARCHAR(30) 	NOT NULL,													--����
	passwd			VARCHAR(30)		NOT NULL                                                    --�н�����
);
INSERT INTO Manager(managerName, passwd) VALUES('�̿���', '1234'); 


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
	categoryId		BIGINT		PRIMARY	KEY	GENERATED	ALWAYS	AS	IDENTITY,					--ī�װ� PK
	categoryName	VARCHAR(30)	NOT	NULL														--ī�װ� �̸�
);

CREATE TABLE Item(
   itemId      	BIGINT		PRIMARY KEY GENERATED ALWAYS AS IDENTITY,							--�޴� PK
   categoryId	BIGINT		NOT	NULL,															--�޴� ����
   itemName		VARCHAR(30) NOT NULL,															--�޴� �̸�
   itemPrice	INT			NOT NULL,															--�޴� ����
   itemUrl		VARCHAR(100)NOT	NULL	DEFAULT	'http://placehold.it/120x120',					--�̹��� �ּ�
   regDate		TIMESTAMP	NOT	NULL	DEFAULT	CURRENT_TIMESTAMP,								--��� ��¥
   CONSTRAINT Item_categoryId_FK	FOREIGN	KEY(categoryId)	REFERENCES	Category(categoryId)
);

CREATE TABLE SalesTotalPrice(
	stpId			BIGINT	PRIMARY	KEY	GENERATED	ALWAYS	AS	IDENTITY,						--���ǸŰ��� PK
	orderNum	BIGINT		NOT	NULL,															--�ֹ� ��ȣ
	totalPrice		INT		NOT	NULL,															--���ǸŰ���
	reducedPrice	INT		NOT	NULL	DEFAULT	0,												--���� ����(���ǸŰ��� - ���ϸ������ΰ���)
	orderDate	TIMESTAMP	NOT	NULL	DEFAULT	CURRENT_TIMESTAMP								--�ֹ� ��¥
);

CREATE TABLE SalesHistory (
	shId		BIGINT		PRIMARY	KEY	GENERATED	ALWAYS	AS	IDENTITY,						--�Ǹų��� PK
	itemId		BIGINT		NOT NULL,															--FK(�޴� PK)
	orderNum	BIGINT		NOT	NULL,															--�ֹ� ��ȣ
	numOfSales	INT			NOT NULL	DEFAULT	0,												--����
	paidPrice	INT			NOT	NULL	DEFAULT	0,												--���� ����
	orderDate	TIMESTAMP	NOT	NULL	DEFAULT	CURRENT_TIMESTAMP,								--�ֹ� ��¥
	CONSTRAINT SalesHistory_itemId_FK FOREIGN KEY(itemId) REFERENCES Item(itemId)
);

--DELETE FROM Item WHERE itemId = 1;
--DELETE FROM SalesHistory WHERE itemId = 2;

SELECT categoryId, categoryName FROM Category ORDER BY 2;

ALTER TABLE SalesHistory DROP CONSTRAINT SalesHistory_itemId_FK;
ALTER TABLE SalesHistory ADD CONSTRAINT SalesHistory_itemId_FK FOREIGN KEY(itemId) REFERENCES Item(itemId);