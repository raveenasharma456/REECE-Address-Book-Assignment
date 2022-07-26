drop table MST_ADDRESS_BOOK;

CREATE TABLE MST_ADDRESS_BOOK
( ADDRESS_BOOK_TYPE  IDENTITY NOT NULL PRIMARY KEY , 
    ADDRESS_BOOK_TYPE_NAME  VARCHAR NOT NULL ,
    CREATED_DT TIMESTAMP WITH TIME ZONE , 
    CREATED_BY VARCHAR ) ;


insert into MST_ADDRESS_BOOK (ADDRESS_BOOK_TYPE  ,ADDRESS_BOOK_TYPE_NAME,CREATED_DT,CREATED_BY) values ('1','Plumbing',CURRENT_TIMESTAMP(),'RSharma');
insert into MST_ADDRESS_BOOK (ADDRESS_BOOK_TYPE  ,ADDRESS_BOOK_TYPE_NAME,CREATED_DT,CREATED_BY) values ('2','Tiles',CURRENT_TIMESTAMP (),'RSharma');

drop table TILES_ADDRESS_BOOK ;

drop table PLUMBING_ADDRESS_BOOK ;

drop table MST_CUSTOMER_DETAILS ;

CREATE TABLE MST_CUSTOMER_DETAILS (
    CUSTOMER_ID IDENTITY NOT NULL PRIMARY KEY,
    FIRST_NAME VARCHAR ,
    MIDDLE_NAME VARCHAR,
    LAST_NAME VARCHAR ,
    CONTACT_NO VARCHAR,
    IS_PLUMBING_CUSTOMER BOOLEAN ,
    IS_TILES_CUSTOMER BOOLEAN  ,
    CREATED_DT Date,
    CREATED_BY VARCHAR,
    UPDATED_DT Date,
    UPDATED_BY VARCHAR
);

CREATE TABLE PLUMBING_ADDRESS_BOOK (
    PLUMBING_TYPE_ID IDENTITY PRIMARY KEY,
    CUSTOMER_ID VARCHAR NOT NULL,
ORDER_AMOUNT VARCHAR,
    CREATED_DT Date,
    CREATED_BY VARCHAR,
    UPDATED_DT Date,
    UPDATED_BY VARCHAR
);


CREATE TABLE TILES_ADDRESS_BOOK (
    TILES_TYPE_ID IDENTITY PRIMARY KEY,
    CUSTOMER_ID VARCHAR NOT NULL,
ORDER_AMOUNT VARCHAR,
    CREATED_DT Date,
    CREATED_BY VARCHAR,
    UPDATED_DT Date,
    UPDATED_BY VARCHAR
);

