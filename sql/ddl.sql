CREATE TABLE boost_guestbook
(
    id      BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    name    varchar(255) NOT NULL,
    content TEXT NULL,
    regdate datetime     NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE boost_log
(
    id      BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    ip      varchar(255) NOT NULL,
    method  varchar(10)  NOT NULL,
    regdate datetime,
    PRIMARY KEY (id)
) ENGINE = InnoDB;