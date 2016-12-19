USE helloroomie;

CREATE TABLE USER (
  ID             BIGINT(20)   NOT NULL AUTO_INCREMENT,
  EMAIL          VARCHAR(100) NOT NULL,
  FIRST_NAME     VARCHAR(50)  NOT NULL,
  LAST_NAME      VARCHAR(50)  NOT NULL,
  CONTACT_NUMBER VARCHAR(12)  NOT NULL,
  PASSWORD       VARCHAR(255) NOT NULL,
  TOKEN          VARCHAR(255) NOT NULL,
  PRIMARY KEY (ID)
)
  ENGINE =InnoDB
  DEFAULT CHARSET =utf8;

CREATE TABLE CITY (
  ID   BIGINT(20)  NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(50) NOT NULL,
  PRIMARY KEY (ID)
)
  ENGINE =InnoDB
  DEFAULT CHARSET =utf8;

CREATE TABLE ZONE (
  ID      BIGINT(20)  NOT NULL AUTO_INCREMENT,
  NAME    VARCHAR(50) NOT NULL,
  CITY_ID BIGINT(20)  NOT NULL,
  PRIMARY KEY (ID)
)
  ENGINE =InnoDB
  DEFAULT CHARSET =utf8;

CREATE TABLE LOCALITY (
  ID      BIGINT(20)  NOT NULL AUTO_INCREMENT,
  NAME    VARCHAR(50) NOT NULL,
  ZONE_ID BIGINT(20)  NOT NULL,
  PRIMARY KEY (ID)
)
  ENGINE =InnoDB
  DEFAULT CHARSET =utf8;


CREATE TABLE AD (
  ID            BIGINT(20)   NOT NULL AUTO_INCREMENT,
  ALLOWED_TO    VARCHAR(100) NOT NULL,
  CREATED_ON    DATETIME     NOT NULL,
  DESCRIPTION   VARCHAR(255) NOT NULL,
  ACTIVE        BOOLEAN      NOT NULL DEFAULT FALSE,
  ROOMS         INT          NOT NULL,
  RENT          VARCHAR(20)  NOT NULL,
  TITLE         VARCHAR(255) NOT NULL,
  UPDATED_ON    DATETIME     NOT NULL,
  LOCALITY_ID   BIGINT(20)   NOT NULL,
  ADVERTISER_ID BIGINT(20)   NOT NULL,
  PRIMARY KEY (ID)
)
  ENGINE =InnoDB
  DEFAULT CHARSET =utf8;

CREATE TABLE IMAGE (
  ID         BIGINT(20)  NOT NULL AUTO_INCREMENT,
  IMAGE_DATA LONGBLOB    NOT NULL,
  IMAGE_NAME VARCHAR(50) NOT NULL,
  PRIMARY KEY (ID)
)
  ENGINE =InnoDB
  DEFAULT CHARSET =utf8;


CREATE TABLE AD_IMAGE (
  AD_ID    BIGINT(20) NOT NULL,
  IMAGE_ID BIGINT(20) NOT NULL
)
  ENGINE =InnoDB
  DEFAULT CHARSET =utf8;


ALTER TABLE ZONE
ADD CONSTRAINT ZONE_FK_CITY FOREIGN KEY (CITY_ID) REFERENCES CITY (ID);

ALTER TABLE LOCALITY
ADD CONSTRAINT LOCALITY_FK_ZONE FOREIGN KEY (ZONE_ID) REFERENCES ZONE (ID);

ALTER TABLE AD
ADD CONSTRAINT AD_FK_ADVERTISER FOREIGN KEY (ADVERTISER_ID) REFERENCES USER (ID);

ALTER TABLE AD
ADD CONSTRAINT AD_FK_LOCALITY FOREIGN KEY (LOCALITY_ID) REFERENCES LOCALITY (ID);

ALTER TABLE AD_IMAGE
ADD CONSTRAINT AD_IMAGE_FK_AD FOREIGN KEY (AD_ID) REFERENCES AD (ID);

ALTER TABLE AD_IMAGE
ADD CONSTRAINT AD_IMAGE_FK_IMAGE FOREIGN KEY (IMAGE_ID) REFERENCES IMAGE (ID);

ALTER TABLE AD_IMAGE
ADD CONSTRAINT UK_AD_IMAGE_ID  UNIQUE KEY (IMAGE_ID);