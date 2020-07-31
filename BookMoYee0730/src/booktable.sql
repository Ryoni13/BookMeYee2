CREATE TABLE booktable(
titleNum Number(10), 
title VARCHAR2(100),
writer VARCHAR2(50),
publisher VARCHAR2(50),
category VARCHAR2(30),
price number(10),
dealtype Varchar2(20),
id VARCHAR2(30)
)

drop table booktable

insert into booktable values (book_SEQ.NEXTVAL, '부의 추월차선', '김리현', '스마트', '아동', 25,'직거래','123')
insert into booktable values (book_SEQ.NEXTVAL, '파이썬', '브리즈', 'SMHRD', '교양', 25,'배달','123')


select * from booktable

CREATE SEQUENCE book_SEQ
START WITH 1 
INCREMENT BY 1
MAXVALUE 1000 
MINVALUE 1 
NOCYCLE 

DROP SEQUENCE book_SEQ

