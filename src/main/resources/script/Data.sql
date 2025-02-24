SELECT * FROM author;
SELECT * FROM author where author_id =2;
UPDATE author SET name = 'ko' ,gender='male' WHERE author_id =3;
DELETE FROM author WHERE author_id=3;
INSERT INTO author(name, gender) VALUES ('daro','male');

-- book
SELECT * FROM book;
SELECT * FROM book WHERE book_id =1;

SELECT c.category_id,name FROM category c INNER JOIN book_category bc ON c.category_id = bc.category_id WHERE book_id =2;