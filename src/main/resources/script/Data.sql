SELECT * FROM author;
SELECT * FROM author where author_id =2;
UPDATE author SET name = 'ko' ,gender='male' WHERE author_id =3;
DELETE FROM author WHERE author_id=3;
INSERT INTO author(name, gender) VALUES ('daro','male')