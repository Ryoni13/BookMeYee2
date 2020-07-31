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

insert into booktable values (book_SEQ.NEXTVAL, '���� �߿�����', '�踮��', '����Ʈ', '�Ƶ�', 25,'���ŷ�','123')
insert into booktable values (book_SEQ.NEXTVAL, '���̽�', '�긮��', 'SMHRD', '����', 25,'���','123')


select * from booktable

CREATE SEQUENCE book_SEQ
START WITH 1 
INCREMENT BY 1
MAXVALUE 1000 
MINVALUE 1 
NOCYCLE 

DROP SEQUENCE book_SEQ

