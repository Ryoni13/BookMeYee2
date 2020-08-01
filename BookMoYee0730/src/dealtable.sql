DROP SEQUENCE op_SEQ

create table deal (dealnumber number(20),
id varchar2(20) NOT NULL,
phonenumber varchar2(20) NOT NULL,
title varchar2(100) NOT NULL,
location varchar2(30) NOT NULL,
price number(20) NOT NULL,
locaInfo float(20) NOT NULL,
CONSTRAINT deal_dealnumber_pk primary key(dealnumber),
CONSTRAINT deal_id_fk foreign key(id, location, phonenumber)
references membertable(id, location, phonenumber));



CREATE SEQUENCE op_SEQ
    INCREMENT BY 1
    START WITH 10
    MAXVALUE 9999999
    NOCACHE
    NOCYCLE;

insert into deal values (op_SEQ.NEXTVAL, 'qwe', '010', '¡÷»Ò¿« ¿œªÛ', '±§¡÷ Ω÷√Ãµø', 45, 1.2653);


