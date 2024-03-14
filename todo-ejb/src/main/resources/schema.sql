CREATE SEQUENCE users_seq;

CREATE TABLE IF NOT EXISTS TODO_USERS (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(256) UNIQUE NOT NULL,
    email VARCHAR(256) UNIQUE,
    enabled BOOLEAN NOT NULL
);

ALTER SEQUENCE users_seq OWNED BY TODO_USERS.user_id;

CREATE TABLE IF NOT EXISTS TODO_CATEGORIES (
    category_id SERIAL PRIMARY KEY,
    category_name VARCHAR(128) NOT NULL UNIQUE,
    category_description VARCHAR(256) NOT NULL
);
