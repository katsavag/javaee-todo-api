CREATE SEQUENCE users_seq;

CREATE TABLE IF NOT EXISTS TODO_USERS
(
    user_id BIGINT PRIMARY KEY,
    username VARCHAR (256) UNIQUE NOT NULL,
    email VARCHAR (256) UNIQUE,
    enabled BOOLEAN NOT NULL
    );

ALTER SEQUENCE users_seq OWNED BY TODO_USERS.user_id;

CREATE TABLE IF NOT EXISTS TODO_CATEGORIES
(
    category_id BIGINT PRIMARY KEY,
    category_name VARCHAR (128) NOT NULL UNIQUE,
    category_description VARCHAR (256) NOT NULL
);

CREATE TABLE TodoItems
(
    todo_item_id BIGINT PRIMARY KEY,
    title       VARCHAR(255) NOT NULL ,
    description VARCHAR(255),
    due_date    DATE NOT NULL ,
    completed   BOOLEAN NOT NULL ,
    priority    VARCHAR(50) NOT NULL ,
    category_id BIGINT NOT NULL ,
    user_id     BIGINT NOT NULL ,
    FOREIGN KEY (category_id) REFERENCES Categories (id),
    FOREIGN KEY (user_id) REFERENCES Users (id)
);

CREATE SEQUENCE todo_item_seq START WITH 1 INCREMENT BY 1;

