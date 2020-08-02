//순서대로 create는 반대
drop table deal
drop table delivery
drop table book
drop table membertable


CREATE TABLE membertable(name varchar2(20) not null, 
id varchar2(20),
pw varchar2(20) NOT NULL,
phonenumber varchar2(20) NOT NULL,
bread number(10),
location varchar2(30),
latitude float(20) NOT NULL,
longitude float(20) NOT NULL,
memnum number(10) NOT NULL,
CONSTRAINT membertable_id_pk PRIMARY KEY(id, phonenumber, location));

CREATE SEQUENCE MEMNUM_SEQ
    INCREMENT BY 1
    START WITH 1
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;
    
DROP SEQUENCE  MEMNUM_SEQ

insert into membertable values('김정완', '123','123','010', 20, '광주 치평동', 35.14122, 126.8394, MEMNUM_SEQ.NEXTVAL);
insert into membertable values('강주희', 'qwe','qwe','010', 20, '광주 쌍촌동', 35.15204, 126.863, MEMNUM_SEQ.NEXTVAL);
insert into membertable values('김리현', 'asd','asd','010', 20, '광주 치평동', 35.15325, 126.8446, MEMNUM_SEQ.NEXTVAL);
insert into membertable values('이향선', 'zxc','zxc','010', 20, '광주 첨단2지구', 35.21419, 126.8693, MEMNUM_SEQ.NEXTVAL);
insert into membertable values('조문형', '456','456','010', 20, '광주 두암동', 35.17114, 126.9364, MEMNUM_SEQ.NEXTVAL);

select * from membertable;


//////////////////////////////////////////////////////전에있던거///////////////////////////////////////////////////
insert into membertable values('이향선', '456', '456', '010', 20, '두암동', 35.15204, 126.863,  MEMBERTABLE_ID_SEQ.NEXTVAL)


select * from membertable;


//////


CREATE SEQUENCE MEMBERTABLE_ID_SEQ
START WITH 1 
INCREMENT BY 1
MAXVALUE 1000 
MINVALUE 1 
NOCYCLE 

SELECT EX_SEQ.CURRVAL FROM DUAL --해당 시퀀스 값 조회

SELECT * FROM USER_SEQUENCES  --전체 시퀀스 조회


select * from booktable where dealcar = '교환'
