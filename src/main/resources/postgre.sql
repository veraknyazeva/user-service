-- CREATE SCHEMA user_service;
--
-- CREATE TABLE user_data(
--     id serial PRIMARY KEY,
--     email varchar(255),
--     password varchar(255),
--     name varchar(255),
--     role varchar(5),
--     FOREIGN KEY (role) REFERENCES role(id)
-- );
--
--
--
-- CREATE TABLE role(
--     id serial PRIMARY KEY,
--     role varchar(5)
-- );