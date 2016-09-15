
create table t86_board (
	no number(6) primary key,
	title varchar2(300) not null,
	writer varchar2(30) not null,
	content varchar2(4000) not null,
	reg_date date default sysdate
);

create sequence s86_board_no;


create table t86_comment (
	comment_no number(6) primary key,
	no number(6) not null,
	content varchar2(200) not null,
	id varchar2(20) not null,
	reg_date date default sysdate
);

create sequence s86_comment_no;


create table t86_board_file (
	file_no number primary key,
	no number(6) not null,
	ori_file_name varchar2(200) not null,
	real_file_name varchar2(200) not null,
	file_path varchar2(100) not null,
	file_size number not null
);

create sequence s86_board_file_no;

create table t86_member (
	member_no number primary key,
	member_id varchar2(100) not null,
	member_pass varchar2(100) not null
);

create sequence s86_member_no;

insert into t86_member
values (s86_member_no.nextVal, 'admin', 'admin');
insert into t86_member
values (s86_member_no.nextVal, 'a', '1');



