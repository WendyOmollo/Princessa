

SET MODE PostgreSQL;


CREATE DATABASE princessdomain;

\c princessdomain;

CREATE TABLE princesses (id SERIAL PRIMARY KEY, name varchar, age integer, strength varchar, weakness varchar, domain_id integer);

CREATE TABLE domains (id SERIAL PRIMARY KEY, name varchar, maxSize integer, cause varchar);

CREATE DATABASE princessdomain_test WITH TEMPLATE princessdomain;
