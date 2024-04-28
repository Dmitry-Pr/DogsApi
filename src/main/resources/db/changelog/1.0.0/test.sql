-- liquibase formatted sql
-- changeset dvmukhin@edu.hse.ru:1 logicalFilePath:1.0.0/test.sql
CREATE TABLE cached_response
(
    id        VARCHAR(255) PRIMARY KEY NOT NULL,
    response  TEXT,
    timestamp TIMESTAMP
);
-- rollback DROP TABLE cached_response;