-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-10-12 10:59:53.233

-- tables
-- Table: user
CREATE TABLE "user" (
    id serial  NOT NULL,
    first_name varchar(50)  NOT NULL,
    last_name varchar(50)  NOT NULL,
    mobile_number varchar(50)  NOT NULL,
    company_name varchar(255)  NOT NULL,
    job_title varchar(100)  NOT NULL,
    company_size int  NOT NULL,
    password varchar(100)  NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- End of file.

