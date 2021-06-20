 create user 'paas'@'%' identified by '123456';

grant all privileges on `editestdb`.* to 'paas'@'%' identified by '123456' with grant option;
flush privileges;

create database demo DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS `corpus`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `problem` VARCHAR(100) NOT NULL,
   `answer` TEXT NOT NULL,
   `praise` INT DEFAULT '0',
   `dislike` INT DEFAULT '0',
   `counts` INT DEFAULT '0',
   `createTime` TIMESTAMP,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO corpus ( problem, answer)
                       VALUES
                       ( "你喜欢吃什么", "我喜欢吃油条");

INSERT INTO corpus ( problem, answer)
                       VALUES
                       ( "你喜欢喝什么", "我喜欢喝豆浆");

# id name phone email  school question

CREATE TABLE IF NOT EXISTS `board`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(50) NOT NULL,
   `phone` VARCHAR(20) NOT NULL,
   `email` VARCHAR(20) NOT NULL,
   `school` VARCHAR(50) NOT NULL ,
   `question` VARCHAR(100) NOT NULL ,
   `createTime` TIMESTAMP,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

# id username phone   password

CREATE TABLE IF NOT EXISTS `user`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `username` VARCHAR(50) NOT NULL,
   `phone` VARCHAR(20),
   `password` VARCHAR(50) NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;