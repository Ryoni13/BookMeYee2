drop table membertable

CREATE TABLE membertable(memnum number(10), name VARCHAR2(20),id VARCHAR2(20), pw VARCHAR2(20),  phoneNumber VARCHAR2(20), 
bread number(10), location VARCHAR2(30), latitude float(20), longitude float(20));


insert into membertable values(MEM_SEQ.NEXTVAL,'김정완', '123','123','010', 20,'광주 치평동', 35.14122, 126.8394)
insert into membertable values(MEM_SEQ.NEXTVAL,'강주희', 'qwe','qwe','010', 20,'광주 쌍촌동', 35.15204, 126.863)
insert into membertable values(MEM_SEQ.NEXTVAL,'김리현', 'asd','asd','010', 20,'광주 치평동', 35.15325, 126.8446)
insert into membertable values(MEM_SEQ.NEXTVAL,'이향선', 'zxc','zxc','010', 20,'광주 첨단2지구', 35.21419, 126.8693)
insert into membertable values(MEM_SEQ.NEXTVAL,'조문형', '456','456','010', 20,'광주 두암동', 35.17114, 126.9364)

delete from MEMBERTABLE where name = '김리현메르시'

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

SELECT EX_SEQ.CURRVAL FROM DUAL --해당 시퀀스 값 조회

SELECT * FROM USER_SEQUENCES  --전체 시퀀스 조회
