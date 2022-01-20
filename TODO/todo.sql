# demo 데이터 베이스를 생성하고 utf8mb4(모든문자, 한글, 이모지포함)
CREATE DATABASE IF NOT EXISTS demo 
DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

use demo;

DROP TABLE IF EXISTS users; # users 테이블이 있으면 삭제
CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT,	# 자동으로 1씩 증가 생성
  firstName varchar(20) DEFAULT NULL,
  lastName varchar(20) DEFAULT NULL,
  userName varchar(250) DEFAULT NULL, # 유저 이름
  password varchar(20) DEFAULT NULL,  # 비밀번호users
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS todos; # 할일 테이블이 있으면 삭제
CREATE TABLE todos (
  id INT NOT NULL AUTO_INCREMENT,	# 자동으로 1씩 증가 생성
  description varchar(255) DEFAULT NULL, # 할일 설명
  is_done bit(1) NOT NULL,				 # 완료됨
  target_date datetime(6) DEFAULT NULL,	 # 목표 날짜 
  username varchar(255) DEFAULT NULL,	 # 유저 이름
  title varchar(255) DEFAULT NULL,		 # 할일 이름
  PRIMARY KEY (id)
);