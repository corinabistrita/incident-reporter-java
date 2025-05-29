CREATE DATABASE incident_reporter;
USE incident_reporter;


CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(40) UNIQUE NOT NULL,
    password VARCHAR(40) NOT NULL,
    role VARCHAR(10) CHECK (role IN ('user', 'admin')) NOT NULL
);

CREATE TABLE incidents (
    incident_id INT PRIMARY KEY AUTO_INCREMENT,
    incident VARCHAR(200) NOT NULL,
    description TEXT,
    priority VARCHAR(20) CHECK (priority IN ('Low', 'Medium', 'High', 'Urgent')) DEFAULT 'Medium',
    status VARCHAR(20) CHECK (status IN ('Open', 'In Progress', 'Resolved')) DEFAULT 'Open',
    user_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE incident_comments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    incident_id INT NOT NULL,
    user_id INT NOT NULL,
    comment TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (incident_id) REFERENCES incidents(incident_id)
);

CREATE TABLE incident_history (
    id INT PRIMARY KEY AUTO_INCREMENT,
    incident_id INT NOT NULL,
    old_status VARCHAR(20),
    new_status VARCHAR(20),
    changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    changed_by INT,
    FOREIGN KEY (incident_id) REFERENCES incidents(incident_id),
    FOREIGN KEY (changed_by) REFERENCES users(id)
);

INSERT INTO users (username, password, role) VALUES
('admin1', 'adminpass', 'admin'),
('user1', 'userpass1', 'user'),
('user2', 'userpass2', 'user'),
('user3', 'userpass3', 'user'),
('user4', 'userpass4', 'user');

INSERT INTO incidents (incident, description, priority, status, user_id) VALUES
('Computer won't start', 'Black screen on boot', 'Urgent', 'Open', 2),
('WiFi network issues', 'Unstable connection in office', 'Medium', 'In Progress', 3),
('Email not syncing', 'Emails are delayed', 'High', 'Open', 4),
('Printer not working', 'Printer shows error code E05', 'Medium', 'Resolved', 2),
('Software installation failed', 'Error code 404 during install', 'High', 'Open', 5);

INSERT INTO incident_comments (incident_id, user_id, comment) VALUES
(1, 2, 'Tried restarting, no luck'),
(1, 1, 'Will check hardware tomorrow'),
(2, 3, 'Issue seems related to router'),
(3, 4, 'Noticed problem after last update'),
(4, 2, 'Replaced toner, problem fixed');

INSERT INTO incident_history (incident_id, old_status, new_status, changed_by) VALUES
(2, 'Open', 'In Progress', 1),
(4, 'In Progress', 'Resolved', 1),
(5, 'Open', 'In Progress', 1),
(3, 'Open', 'In Progress', 1),
(1, 'Open', 'In Progress', 1);


