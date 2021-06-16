 create user 'paas'@'%' identified by '123456';

grant all privileges on `editestdb`.* to 'paas'@'%' identified by '123456' with grant option;
flush privileges;

create database demo DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS `corpus`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `problem` VARCHAR(100) NOT NULL,
   `answer` TEXT NOT NULL,
   `like` INT DEFAULT '0',
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




