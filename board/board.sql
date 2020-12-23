create table board(
	bno number(8),
	name nvarchar2(10) not null,
	password varchar2(15) not null,
	title nvarchar2(50) not null,
	content nvarchar2(1000) not null,
	attach nvarchar2(100),
	re_ref number(8) not null,
	re_lev number(8) not null,
	re_seq number(8) not null,
	readcount number(8) default 0,
	regdate date default sysdate
);

alter table board add constraint pk_board primary key(bno);

create sequence board_seq;

select count(*) from board;

-- 더미 데이터 2배 복사(페이지 나누기) 데이터 1000개 만들기
INSERT INTO board(bno,name,password,title,content,re_ref,re_lev,re_seq)
(SELECT board_seq.nextval,name,password,title,content,board_seq.currval,re_lev,re_seq
FROM board);
--마지막 게시글 번호 조회
select * from board where bno=(select max(bno) from board);

--가장 최신글의 댓글 달기
--re_ref(그룹번호 : 원본글의 re_ref번호)
--re_lev(원본글의 댓글인지 혹은 댓글의 댓글인지 : 원본글의 re_lev+1)
--re_seq(댓글의 순서 : 원본글의 re_seq+1)
insert into board(bno,name,password,title,content,attach,re_ref,re_lev,re_seq)
values(board_seq.nextval,'hong','1234','댓글연습1','댓글 연습중',null,2310,1,1);

-- 댓글작업하기
--1.기존 댓글의 re_seq 값 변경하기(기존댓글이 존재한다면 re_seq+1)(원본re_seq는 항상0이니깐 0보다 큰것으로 댓글 구분)
update board set re_seq = re_seq+1 where re_ref=2310 and re_seq > 0;

--2.댓글 삽입
--두번째 댓글
insert into board(bno,name,password,title,content,attach,re_ref,re_lev,re_seq)
values(board_seq.nextval,'kang','1234','댓글연습2','댓글 연습중',null,2310,1,1);

--3.원본글과 댓글 가져오기
select bno,name,title,re_ref,re_lev,re_seq from board 
where re_ref=2310 order by re_seq;

--댓글의 댓글 달기 (원본글의 re_ref,re_seq,re_lev 필요)
--1.기존 댓글의 re_seq 값 변경하기(기존댓글이 존재한다면 re_seq+1)
--re_seq > 1 : 원본 댓글의 re_seq값 보다 큰거
update board set re_seq = re_seq+1 where re_ref=2310 and re_seq > 1;

--2.댓글의 댓글 삽입
--두번째 댓글
insert into board(bno,name,password,title,content,attach,re_ref,re_lev,re_seq)
values(board_seq.nextval,'choi','1234','Re:댓글연습','댓글 연습중',null,2310,2,2);

--3.원본댓글과 댓글의 댓글 가져오기
select bno,name,title,re_ref,re_lev,re_seq from board 
where re_ref=2310 order by re_seq;


