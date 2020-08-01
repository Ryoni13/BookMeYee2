
CREATE TABLE book(titlenumber number(10) NOT NULL, 
title varchar2(100) NOT NULL,
writer varchar2(50) NOT NULL,
publisher varchar2(50) NOT NULL,
category varchar2(30),
price number(20) NOT NULL,
dealtype varchar2(20),
id varchar2(20),
dealcar varchar2(10) NOT NULL,
phonenumber varchar2(20) NOT NULL,
location varchar2(30),
CONSTRAINT book_titlenumber_pk primary key(titleNumber, title),
CONSTRAINT book_id_fk foreign key(id, phonenumber, location) references membertable(id, phonenumber, location),
CONSTRAINT book_category_ck CHECK (category in('아동', '소설', '자기계발서', '문제집', '잡지', '만화')),
CONSTRAINT book_dealtype_ck CHECK (dealtype in('직거래', '배달')),
CONSTRAINT book_dealcar_ck CHECK (dealcar in('판매', '교환', '나눔')));

DROP SEQUENCE  tn_SEQ

CREATE SEQUENCE tn_SEQ
    INCREMENT BY 1
    START WITH 10
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;
    
    
insert into book values (tn_SEQ.NEXTVAL,'리현의 일상', '김리현', 'SMHRD', '아동', 20, 
'직거래', '123', '판매', '010', '광주 치평동');
insert into book values (tn_SEQ.NEXTVAL,'문형의 일상', '조문형', 'SMHRD', '자기계발서', 30, 
'배달','qwe', '교환', '010', '광주 쌍촌동');
insert into book values (tn_SEQ.NEXTVAL,'주희의 일상', '강주희', 'SMHRD', '소설', 0, 
'직거래','qwe', '나눔', '010', '광주 쌍촌동');
insert into book values (tn_SEQ.NEXTVAL,'향선의 일상', '이향선', 'SMHRD', '잡지', 10, 
'직거래','asd', '판매', '010', '광주 치평동');
insert into book values (tn_SEQ.NEXTVAL,'정완이의 일상', '김정완', 'SMHRD', '문제집', 3, 
'배달','123', '나눔', '010', '광주 치평동');











////////////////////////////////////////////////전에있던거/////////////////////////////////////////////////////////


CREATE TABLE booktable(
titleNumber number(10), 
title varchar2(100) NOT NULL,
writer varchar2(50) NOT NULL,
publisher varchar2(50) NOT NULL,
category varchar2(30),
price number(20) NOT NULL,
dealtype varchar2(20),
id varchar2(30),
dealcar varchar2(10) NOT NULL
)

insert into booktable values (book_titlenumber_SEQ.NEXTVAL, '부의 추월차선', '김리현', '스마트', '아동', 25,'직거래','123','판매')

select * from booktable

CREATE SEQUENCE book_titlenumber_SEQ
    INCREMENT BY 1
    START WITH 100
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;




