--TABLE ��ȸ --
SELECT * FROM Customer;
SELECT * FROM Mileage;
SELECT * FROM TotalMileage;
SELECT * FROM Menu;
SELECT * FROM SalesHistory;

--TABLE ���� --
DROP TABLE Customer;
DROP TABLE Mileage;
DROP TABLE TotalMileage;
DROP TABLE Menu;
DROP TABLE SalesHistory;

CREATE TABLE Customer(
   cid      BIGINT			PRIMARY KEY GENERATED ALWAYS AS IDENTITY,							--�� PK
   name   	VARCHAR(30) 	NOT NULL,															--�̸�
   phone   	VARCHAR(20)		NOT NULL,                                                           --�޴�����ȣ
   regDate	TIMESTAMP		NOT	NULL	DEFAULT	CURRENT_TIMESTAMP								--��� ��¥
);

CREATE TABLE Mileage(
	mileageId	BIGINT		PRIMARY	KEY	GENERATED ALWAYS AS IDENTITY,							--���ϸ��� PK
	customerId	BIGINT		NOT	NULL,															--FK(�� PK)
	orderNum	BIGINT		NOT	NULL,															--�ֹ� ��ȣ
	mBalance	INT			NOT	NULL	DEFAULT	0,												--���ϸ��� �ܾ�
	regDate		TIMESTAMP	NOT	NULL	DEFAULT	CURRENT_TIMESTAMP,								--���� ��¥
	CONSTRAINT	Mileage_customerId_FK	FOREIGN	KEY(customerId)	REFERENCES	Customer(cid)
);

CREATE TABLE TotalMileage(
	tmId			BIGINT		PRIMARY	KEY	GENERATED	ALWAYS	AS	IDENTITY,					--�� ���ϸ��� PK	
	customerId		BIGINT		NOT	NULL,														--FK(�� PK)
	mileageTotal	INT			NOT	NULL	DEFAULT	0,											--�� ���ϸ����ݾ�
	CONSTRAINT	TotalMileage_customerId_FK	FOREIGN	KEY(customerId)	REFERENCES	Customer(cid)	
);

CREATE TABLE Menu(
   mid      	BIGINT		PRIMARY KEY GENERATED ALWAYS AS IDENTITY,							--�޴� PK
   category		VARCHAR(30)	NOT	NULL,															--�޴� ����
   menuName		VARCHAR(30) NOT NULL,															--�޴� �̸�
   menuPrice	INT			NOT NULL															--�޴� ����
);

CREATE TABLE SalesHistory (
	sid			BIGINT		PRIMARY	KEY	GENERATED	ALWAYS	AS	IDENTITY,						--�Ǹų��� PK
	menuId		BIGINT		NOT NULL,															--FK(�޴� PK)
	orderNum	BIGINT		NOT	NULL,															--�ֹ� ��ȣ
	numOfSales	INT			NOT NULL	DEFAULT	0,												--����
	paidPrice	INT			NOT	NULL	DEFAULT	0,												--���� ����
	orderDate	TIMESTAMP	NOT	NULL	DEFAULT	CURRENT_TIMESTAMP,								--�ֹ� ��¥
	CONSTRAINT SalesHistory_menuId_FK FOREIGN KEY(menuId) REFERENCES Menu(mid)
);

--DELETE FROM Menu WHERE mid = 3;
--DELETE FROM SalesHistory WHERE menuId = 2;

ALTER TABLE SalesHistory DROP CONSTRAINT SalesHistory_menuId_FK;
ALTER TABLE SalesHistory ADD CONSTRAINT SalesHistory_menuId_FK FOREIGN KEY(menuId) REFERENCES Menu(mid);