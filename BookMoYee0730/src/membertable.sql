drop table membertable

CREATE TABLE membertable(memnum number(10), name VARCHAR2(20),id VARCHAR2(20), pw VARCHAR2(20),  phoneNumber VARCHAR2(20), 
bread number(10), location VARCHAR2(30), latitude float(20), longitude float(20));


insert into membertable values(MEM_SEQ.NEXTVAL,'������', '123','123','010', 20,'���� ġ��', 35.14122, 126.8394)
insert into membertable values(MEM_SEQ.NEXTVAL,'������', 'qwe','qwe','010', 20,'���� ���̵�', 35.15204, 126.863)
insert into membertable values(MEM_SEQ.NEXTVAL,'�踮��', 'asd','asd','010', 20,'���� ġ��', 35.15325, 126.8446)
insert into membertable values(MEM_SEQ.NEXTVAL,'���⼱', 'zxc','zxc','010', 20,'���� ÷��2����', 35.21419, 126.8693)
insert into membertable values(MEM_SEQ.NEXTVAL,'������', '456','456','010', 20,'���� �ξϵ�', 35.17114, 126.9364)

delete from MEMBERTABLE where name = '�踮���޸���'

select * from membertable;

drop table membertable


//////

DROP SEQUENCE MEM_SEQ

CREATE SEQUENCE MEM_SEQ
START WITH 1 
INCREMENT BY 1
MAXVALUE 1000 
MINVALUE 1 
NOCYCLE 

SELECT EX_SEQ.CURRVAL FROM DUAL --�ش� ������ �� ��ȸ

SELECT * FROM USER_SEQUENCES  --��ü ������ ��ȸ
