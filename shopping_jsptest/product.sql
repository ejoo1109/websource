create table productTBL (
	num number(8),
	category varchar2(20) not null,
	name varchar2(50) not null,
	content varchar2(3000) not null,
	psize varchar2(10) not null,
	color varchar2(20) not null,
	amount number(8) not null,
	price number(8) not null,
	day date default sysdate
);

alter table productTBL add constraint pk_product primary key(num);

create sequence prod_seq;

select * from productTBL;