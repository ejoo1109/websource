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

select * from board;

--페이지 나누기

--rownum : order by 절과 사용할때 order by를 적용할 컬럼이 index가 아니라면 
--제대로 결과를 만들어주지 않는다.

--bno : pk값으로 설정했기 때문에 자동으로 인덱스 처리
select rownum,bno,title from board order by bno desc;
select rownum,bno,title from board order by re_ref desc, re_seq asc;

-- 10개의 레코드만 최신순으로 조회
select rownum,bno,title from board where rownum<=10 order by bno desc;
select rownum,bno,title from board where rownum<=10 order by re_ref desc, re_seq asc;

--인덱스 컬럼이 아닌 경우 해결(인라인방식) bno>0 이용시 조회 기능이 향상됨
select rownum,bno,title
from(select bno,title from board where bno>0 order by re_ref desc, re_seq asc)
where rownum<=10;

-- 1 page => 가장 최신글 10개 가져오기
select bno,title
from(select rownum rnum,bno,title
		from(select bno,title 
				from board 
				where bno>0 order by re_ref desc, re_seq asc)
		where rownum<=10)
where rnum>0;

-- 2 page => 가장 최신글 11~20 가져오기
select bno,title,name, regdate,readcount,re_lev
from(select rownum rnum,bno,title,name, regdate,readcount,re_lev
		from(select bno,title,name, regdate,readcount,re_lev
				from board 
				where bno>0 order by re_ref desc, re_seq asc)
		where rownum<=20)
where rnum>10;

-- 자바페이지에서는 sql의 rownum<=?,rnum>? 으로 들어가는데 처리될수 있도록 식을 세움 
-- 1 => 0, 10 (1~10) (1-1)*10, 1*10 1:페이지값 10:보여줄 개수
-- 2 => 10, 20 (11~20) (2-1)*10, 2*10
-- 3 => 20, 30 (21~30) (3-1)*10, 3*10

--검색어가 들어오지 않는 경우의 전체 행 수
select count(*) from board;
--검색어가 들어오는 경우의 게시물 행 수
select count(*) from board where criteria=title and keyword='제목';