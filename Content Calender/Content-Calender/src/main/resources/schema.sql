CREATE TABLE content (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    desc VARCHAR(1000),
    status VARCHAR(50),
    content_type VARCHAR(50),
    date_created TIMESTAMP,
    date_updated TIMESTAMP,
    url VARCHAR(500)
);
