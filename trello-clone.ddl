CREATE TABLE user
(
    user_id   INT PRIMARY KEY AUTO_INCREMENT,
    username  VARCHAR(50)  NOT NULL,
    email     VARCHAR(255) NOT NULL,
    password  VARCHAR(255) NOT NULL,
    role_enum VARCHAR(50)  NOT NULL
);

CREATE TABLE task
(
    task_id     INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(255) NOT NULL,
    due_date    DATE,
    description TEXT,
    status      VARCHAR(50)  NOT NULL
);

CREATE TABLE category
(
    category_id   INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(50) NOT NULL
);

CREATE TABLE board
(
    board_id    INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE user_task
(
    user_task_id INT PRIMARY KEY AUTO_INCREMENT,
    user_fk         INT,
    task_fk         INT,
    category_fk     INT,
    FOREIGN KEY (user_fk) REFERENCES user (user_id) ON DELETE CASCADE,
    FOREIGN KEY (task_fk) REFERENCES task (task_id) ON DELETE SET NULL,
    FOREIGN KEY (category_fk) REFERENCES category (category_id) ON DELETE SET NULL
);

CREATE TABLE board_task
(
    board_task_id INT PRIMARY KEY AUTO_INCREMENT,
    task_fk       INT,
    board_fk      INT,
    FOREIGN KEY (task_fk) REFERENCES user_task (user_task_id) ON DELETE CASCADE,
    FOREIGN KEY (board_fk) REFERENCES board (board_id) ON DELETE SET NULL
);
