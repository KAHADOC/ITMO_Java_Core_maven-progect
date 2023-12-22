## Даны enum тип и таблица:

        CREATE TYPE book_category AS ENUM ('A', 'B', 'C', 'D', 'E');

        CREATE TABLE IF NOT EXISTS tb_books
        (
            id SERIAL PRIMARY KEY,
            name VARCHAR(100) NOT NULL UNIQUE ,
            published_at TIMESTAMPTZ NOT NULL CHECK ( published_at < CURRENT_TIMESTAMP ),
            number_of_pages SMALLINT NOT NULL CHECK ( number_of_pages > 10 ),
            category book_category NOT NULL
        );

        DROP TABLE IF EXISTS tb_books;

## Необходимо создать следующие запросы:
1. добавление данных (по столбцу published_at добавляется только дата);
2. получить книгу по названию; SELECT * FROM books WHERE name = 
3. получить первые 100 (LIMIT 100) книг с количеством страниц меньше 400;
4. получить книги с 101 по 200;  LIMIT 100 OFFSET 100
5. получить книги, опубликованные за последние 2 года;
6. получить книги из категорий 'B', 'D', 'E';
category = 'B' OR category = 'D' OR category = 'E'
category IN ('B', 'D', 'E')
7. получить количество книг с количеством страниц больше 2000;
count(id) AS count WHERE number_of_pages > 2000
8. получить книги, опубликованные с 2019 по 2022 из категории 'A';
   published_at > '2019-01-01' AND published_at < '2022-01-01'
   published_at BETWEEN '2019-01-01' AND '2022-01-01'
9. получить сумму страниц всех книг;
sum(number_of_pages) AS sum_number_of_pages
   number_of_pages * id AS multi
SELECT 