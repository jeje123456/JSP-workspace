DROP TABLE IF EXISTS `COMMENT`;
CREATE TABLE `COMMENT` (
  `id` INT NOT NULL auto_increment,
  `comment` TEXT default NULL,
  `email` varchar(255) default NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `COMMENT` (`comment`,`email`) VALUES ("첫 댓글 입니다.","drv98@naver.com");