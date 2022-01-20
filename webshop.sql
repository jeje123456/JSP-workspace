# webshop 데이터 베이스가 없으면(if not exists) 새로 생성.
# utf8mb4 한글뿐만 아니라, 이모지 포함한 모든 문자 사용 가능
create database if not exists webshop 
default character set utf8mb4 collate utf8mb4_unicode_ci;

use webshop; # 웹샵을 선택

-- # user 테이블 있으면 삭제하고 재생성
-- DROP TABLE IF exists users;
-- create table users(
-- 	id int primary key auto_increment,  # 유저 아이디 자동생성(auto_increment)
--     email varchar(50),					# 이메일
--     password varchar(50)				# 비번
-- );

-- # 샘플 유저 1명 생성
-- insert into users(email, password)
-- value ('drv98@nausersusersver.com','abcd1234');

# user 테이블 있으면 삭제하고 재생성
DROP TABLE IF exists users;
create table users(
	id int primary key auto_increment,  # 유저 아이디 자동생성(auto_increment)
    email varchar(50),					# 이메일
    password varchar(50)				# 비번
);

# 샘플 유저 1명 생성
insert into users(email, password)
value ('drv98@nausersusersver.com','abcd1234');