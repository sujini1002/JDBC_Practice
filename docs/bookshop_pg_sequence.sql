drop sequence seq_author;
create sequence seq_author start 1;

drop sequence seq_book;
create sequence seq_book start 1;

-- 참고 사항
--CREATE TABLE "author"
--(
--	"no"   integer     NOT NULL default nextval('seq_author'), -- 번호
--	"name" VARCHAR(20) NOT NULL  -- 이름
--);

select no,name,contents,to_char(reg_date,'yyyy-mm-dd') from guestbook order by reg_date desc;

insert into guestboot values(null,'sujin','hi~','1234',now());

select * from pet;

select * from author;

show tables;

drop sequence seq_author;

create sequence seq_author start 1;

select nextval('seq_author');

insert into author values(nextval('seq_author'),'connan');

delete from author where no = 5;

select no,name,contents,to_char(reg_date,'yyyy-mm-dd') from guestbook order by reg_date desc;

insert into guestbook values(default,'sujin','hi~','1234',now());

select * from member;

create type enum_book_status as enum('대여중','대여가능');

insert into book values(default,'toby spring','',1);

select * from author;