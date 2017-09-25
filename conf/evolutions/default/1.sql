# testdb schema

# --- !Ups

CREATE TABLE test (
  id integer NOT NULL,
  name varchar(255) NOT NULL,
);

INSERT INTO test VALUES (10, "testing");
