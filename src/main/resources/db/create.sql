

SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS princesses (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  age INTEGER,
  strength VARCHAR,
  weakness VARCHAR,
  domain_id INTEGER
);


CREATE TABLE IF NOT EXISTS domains (
id int PRIMARY KEY auto_increment,
name VARCHAR,
maxSize INTEGER,
cause VARCHAR
);