CREATE DATABASE bookStore;
DROP DATABASE bookStore;
CREATE TABLE author(
  author_id serial PRIMARY KEY,
  name VARCHAR(100),
  gender VARCHAR(8)
);
CREATE TABLE book(
    book_id serial PRIMARY KEY ,
    title VARCHAR(225),
    published_date timestamp,
    author_id INT,
    CONSTRAINT author_fk FOREIGN KEY (author_id) REFERENCES author
                 ON UPDATE CASCADE ON DELETE CASCADE

);
CREATE TABLE category(
    category_id serial PRIMARY KEY ,
    name VARCHAR(225)
);
CREATE TABLE book_category(
    book_id INT NOT NULL ,
    category_id INT NOT NULL ,
    PRIMARY KEY (book_id,category_id),
    CONSTRAINT  book_fk FOREIGN KEY (book_id) REFERENCES book
                          ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT category_fk FOREIGN KEY (category_id) REFERENCES category
                          ON UPDATE CASCADE ON DELETE CASCADE
);