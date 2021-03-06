DROP TABLE IF EXISTS doctor CASCADE;


CREATE TABLE doctor (
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(128) NOT NULL,
	appointment TIMESTAMP NOT NULL,
	patient VARCHAR(128),
	patient_phone VARCHAR(64),
	comment VARCHAR(2000)
);

--DROP TABLE IF EXISTS users CASCADE;
--
--CREATE TABLE users (
--  id BIGSERIAL PRIMARY KEY,
--  name VARCHAR(128) NOT NULL,
--  email VARCHAR(64) NOT NULL,
--  username VARCHAR(64) NOT NULL,
--  password VARCHAR(64) NOT NULL,
--  enabled BOOLEAN NOT NULL DEFAULT TRUE,
--  UNIQUE(username),
--  UNIQUE(email)
--);
--
--DROP TABLE IF EXISTS role CASCADE;
--
--CREATE TABLE role (
--  id BIGSERIAL PRIMARY KEY,
--  name VARCHAR(32) NOT NULL
--);
--
--DROP TABLE IF EXISTS user_role;
--
--CREATE TABLE user_role (
--  id BIGSERIAL PRIMARY KEY,
--  user_id BIGSERIAL REFERENCES users(id),
--  role_id BIGSERIAL REFERENCES role(id),
--  UNIQUE (user_id, role_id)
--);
