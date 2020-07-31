DROP SEQUENCE book_SEQ

drop table booktable

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

insert into booktable values (book_titlenumber_SEQ.NEXTVAL, '���� �߿�����', '�踮��', '����Ʈ', '�Ƶ�', 25,'���ŷ�','123','�Ǹ�')

select * from booktable

CREATE SEQUENCE book_titlenumber_SEQ
    INCREMENT BY 1
    START WITH 100
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;



