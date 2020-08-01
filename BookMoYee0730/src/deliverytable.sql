drop table delivery

CREATE TABLE delivery (deliverynumber number(20),
id varchar2(20) NOT NULL,
title varchar2(100) NOT NULL,
location varchar2(20) NOT NULL,
deliveryprice number(20) NOT NULL,
phonenumber varchar2(20) NOT NULL,
titleNumber number(10) NOT NULL,
CONSTRAINT delivery_deliverynumber_pk primary key(deliverynumber),
CONSTRAINT delivery_id_fk foreign key(id, phonenumber, location)
references membertable(id, phonenumber, location),
CONSTRAINT delivery_title_fk foreign key(titleNumber, title)
references book(titleNumber, title));

DROP SEQUENCE  dn_SEQ

CREATE SEQUENCE dn_SEQ
    INCREMENT BY 1
    START WITH 10000
    MAXVALUE 9999999
    NOCACHE
    NOCYCLE;
    
insert into delivery values (dn_SEQ.NEXTVAL, 'qwe', '������ �ϻ�', '���� ���̵�', 45, 
'010', (select titleNumber from book where title='������ �ϻ�'));
insert into delivery values (dn_SEQ.NEXTVAL, '123', '�������� �ϻ�', '���� ġ��', 18, 
'010', (select titleNumber from book where title='�������� �ϻ�'));
insert into delivery values (dn_SEQ.NEXTVAL, 'asd', '�⼱�� �ϻ�', '���� ġ��', 45, 
'010', (select titleNumber from book where title='�⼱�� �ϻ�'));    
    
    