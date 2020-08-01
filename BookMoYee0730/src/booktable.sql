
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
CONSTRAINT book_category_ck CHECK (category in('�Ƶ�', '�Ҽ�', '�ڱ��߼�', '������', '����', '��ȭ')),
CONSTRAINT book_dealtype_ck CHECK (dealtype in('���ŷ�', '���')),
CONSTRAINT book_dealcar_ck CHECK (dealcar in('�Ǹ�', '��ȯ', '����')));

DROP SEQUENCE  tn_SEQ

CREATE SEQUENCE tn_SEQ
    INCREMENT BY 1
    START WITH 10
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;
    
    
insert into book values (tn_SEQ.NEXTVAL,'������ �ϻ�', '�踮��', 'SMHRD', '�Ƶ�', 20, 
'���ŷ�', '123', '�Ǹ�', '010', '���� ġ��');
insert into book values (tn_SEQ.NEXTVAL,'������ �ϻ�', '������', 'SMHRD', '�ڱ��߼�', 30, 
'���','qwe', '��ȯ', '010', '���� ���̵�');
insert into book values (tn_SEQ.NEXTVAL,'������ �ϻ�', '������', 'SMHRD', '�Ҽ�', 0, 
'���ŷ�','qwe', '����', '010', '���� ���̵�');
insert into book values (tn_SEQ.NEXTVAL,'�⼱�� �ϻ�', '���⼱', 'SMHRD', '����', 10, 
'���ŷ�','asd', '�Ǹ�', '010', '���� ġ��');
insert into book values (tn_SEQ.NEXTVAL,'�������� �ϻ�', '������', 'SMHRD', '������', 3, 
'���','123', '����', '010', '���� ġ��');











////////////////////////////////////////////////�����ִ���/////////////////////////////////////////////////////////


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




