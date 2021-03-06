CREATE TABLE IF NOT EXISTS USER (
  ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1),
  EMAIL VARCHAR(100) NOT NULL,
  FIRST_NAME VARCHAR(50) NOT NULL,
  LAST_NAME VARCHAR(50) NOT NULL,
  CONTACT_NUMBER VARCHAR(12) NOT NULL,
  PASSWORD VARCHAR(255) NOT NULL,
  TOKEN VARCHAR(255) NOT NULL,
  PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS CITY (
  ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1),
  NAME VARCHAR(50) NOT NULL,
  PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS ZONE (
  ID BIGINT GENERATED BY DEFAULT AS IDENTITY ( START WITH 1, INCREMENT BY 1),
  NAME VARCHAR(50) NOT NULL,
  CITY_ID BIGINT NOT NULL,
  PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS LOCALITY (
  ID BIGINT GENERATED BY DEFAULT AS IDENTITY ( START WITH 1, INCREMENT BY 1),
  NAME VARCHAR(50) NOT NULL,
  ZONE_ID BIGINT NOT NULL,
  PRIMARY KEY (ID)
);


CREATE TABLE IF NOT EXISTS AD (
  ID BIGINT GENERATED BY DEFAULT AS IDENTITY ( START WITH 1, INCREMENT BY 1),
  ALLOWED_TO VARCHAR(100) NOT NULL,
  CREATED_ON DATETIME NOT NULL,
  DESCRIPTION VARCHAR(255) NOT NULL,
  ACTIVE BOOLEAN      DEFAULT TRUE,
  ROOMS INT      NOT NULL,
  RENT VARCHAR(20) NOT NULL,
  TITLE VARCHAR(255) NOT NULL,
  UPDATED_ON DATETIME NOT NULL,
  LOCALITY_ID BIGINT   NOT NULL,
  ADVERTISER_ID BIGINT NOT NULL,
  PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS IMAGE (
  ID BIGINT GENERATED BY DEFAULT AS IDENTITY ( START WITH 1, INCREMENT BY 1),
  IMAGE_DATA VARBINARY(2M) NOT NULL,
  IMAGE_NAME VARCHAR(50) NOT NULL,
  PRIMARY KEY (ID)
);


CREATE TABLE IF NOT EXISTS AD_IMAGE (
  AD_ID BIGINT GENERATED BY DEFAULT AS IDENTITY ( START WITH 1, INCREMENT BY 1),
  IMAGE_ID BIGINT NOT NULL
);

ALTER TABLE ZONE
ADD FOREIGN KEY (CITY_ID) REFERENCES CITY (ID);

ALTER TABLE LOCALITY
ADD FOREIGN KEY (ZONE_ID) REFERENCES ZONE (ID);

ALTER TABLE AD
ADD FOREIGN KEY (ADVERTISER_ID) REFERENCES USER (ID);

ALTER TABLE AD
ADD FOREIGN KEY (LOCALITY_ID) REFERENCES LOCALITY (ID);

ALTER TABLE AD_IMAGE
ADD FOREIGN KEY (AD_ID) REFERENCES AD (ID);

ALTER TABLE AD_IMAGE
ADD FOREIGN KEY (IMAGE_ID) REFERENCES IMAGE (ID);

ALTER TABLE AD_IMAGE
ADD UNIQUE (IMAGE_ID);