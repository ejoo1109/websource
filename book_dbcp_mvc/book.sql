-- bookTBL
-- code 숫자 4 pk
-- title 문자 50
-- writer 문자 20
-- price 숫자 8
create table bookTBL(
	code number(4) primary key,
	title nvarchar2(50) not null,
	writer nvarchar2(20)not null,
	price number(8) not null
);

insert into bookTBL values(1001,'이것이 자바다','신영권',28000);
insert into bookTBL values(1002,'자바의 신','강신용',29000);
insert into bookTBL values(1003,'Do it 자바','김용만',27000);
insert into bookTBL values(1004,'자바 1000제','김진수',32000);

select * from BOOKTBL;