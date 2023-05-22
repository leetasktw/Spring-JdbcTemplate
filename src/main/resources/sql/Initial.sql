create table member (
    id  int(6) NOT NULL AUTO_INCREMENT,
    username varchar(120) NOT NULL,
    password varchar(120) NOT NULL,
    balance double(10, 2),
    PRIMARY KEY (id)
);