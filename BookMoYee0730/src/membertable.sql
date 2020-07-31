drop table membertable

CREATE TABLE membertable(
NAME varchar2(20) not null, 
id varchar2(20),
pw varchar2(20) NOT NULL,
phonenumber varchar2(20) NOT NULL,
bread number(10),
location varchar2(30),
latitude float(20) NOT NULL,
longitude float(20) NOT NULL,
memnum number(10) NOT NULL,
CONSTRAINT membertable_id_pk PRIMARY KEY(id, phonenumber, location));

insert into membertable values('이향선', '456', '456', '010', 20, '두암동', 35.15204, 126.863,  MEMBERTABLE_ID_SEQ.NEXTVAL)

delete from MEMBERTABLE where name = '김리현메르시'

select * from membertable;

//////

DROP SEQUENCE  MEMBERTABLE_ID_SEQ

CREATE SEQUENCE MEMBERTABLE_ID_SEQ
START WITH 1 
INCREMENT BY 1
MAXVALUE 1000 
MINVALUE 1 
NOCYCLE 

SELECT EX_SEQ.CURRVAL FROM DUAL --해당 시퀀스 값 조회

SELECT * FROM USER_SEQUENCES  --전체 시퀀스 조회


select * from booktable where dealcar = '교환'
