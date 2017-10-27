
CREATE TABLE IF NOT EXISTS EMPLOYEE(
	EMPLOYEEID int(10) NOT NULL AUTO_INCREMENT,
	FIRST_NAME   varchar(30) NOT NULL,
	LAST_NAME   varchar(30),
MIDDLE_INITIAL  varchar(30),
	DESCRIPTION  varchar(30),
TITLE    varchar(10),
BIRTHDATE   DATE,
EMP_HIRE_DATE   DATE,
GENDER   VARCHAR(6),
SSN   VARCHAR(15),
ADDRESSID   int(10),
BRANCHID   int(10),
PRIMARYORGANIZATIONID   int(10),
CUSTOMFIELD   varchar(255),
NOTES   varchar(255),
USERNAME   VARCHAR(50),
PASSWORD  VARCHAR(255),
USERSTATUS  varchar(10),
DEACTIVATIONDATE  DATE,
ROLE VARCHAR(255),
MDALLOWMULTIPLESIGNIN  varchar(10),
TRANSACTION_ID  int(10),
    PRIMARY KEY (EMPLOYEEID)
);

CREATE TABLE ROLE(
	ROLEID int(10) NOT NULL AUTO_INCREMENT,
	ROLE  varchar(50) NOT NULL,
DESCRIPTION  varchar(100),
ROLESTATUS	varchar(10),
TRANSACTION_ID  int(10),
    PRIMARY KEY (ROLEID));
Insert table role values(0, �ADMIN�, �Admin Role handler�,�ACTIVE�,);



CREATE TABLE MENU(
	MENUID int(10) NOT NULL AUTO_INCREMENT,
	MENUNAME varchar(50) NOT NULL,
	STATUS varchar(10),
TRANSACTION_ID  int(10),
    PRIMARY KEY (MENUID ));


CREATE TABLE MENUITEMS(
	MENUITEMSID int(10) NOT NULL AUTO_INCREMENT,
	LABEL  varchar(20) NOT NULL,
URL varchar(20),
TOOLTIP varchar(20),
PARENT_MENU varchar(20),
TRANSACTION_ID  int(10),
    PRIMARY KEY (MENUITEMSID ));

Insert table menu values(0, �Admin�, �Admin menu handler�,0,�ACTIVE�);
Insert table menu values(1, �Customer�, �Admin menu handler�,0,�ACTIVE�);

Insert table menu values(2, �Util�, �Admin menu handler�,0,�ACTIVE�);


Insert table role values(0, �ADMIN�, �Admin Role handler�,�ACTIVE�,);

CREATE TABLE TRANSACTION(
	TRANSACTION_ID  int NOT NULL AUTO_INCREMENT,
	TABLE_NAME varchar(50) NOT NULL,
CREATE_USER  varchar(100),
CREATE_DATE	DATE,
UPDATE_USER  varchar(100),
UPDATE_DATE	DATE,
STATUS varchar(10),
INPUTParameters varchar(2000),
    PRIMARY KEY (TRANSACTION_ID));
CREATE TABLE ADDRESS(
	ADDRESSID int(10) NOT NULL AUTO_INCREMENT,
	STREET1	VARCHAR(55),
	STREET2	VARCHAR(55),
	CITY	VARCHAR(35),
	STATE	VARCHAR(20),
	ZIP	VARCHAR(20),
	PHONE	VARCHAR(19),
	WORKPHONE VARCHAR(19),
	EMAIL	VARCHAR(60),
	FAX	VARCHAR(20),
    PRIMARY KEY (ADDRESSID));

