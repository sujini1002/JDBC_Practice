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
