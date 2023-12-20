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

## Необходимо создать следующие запросы:
1. добавление данных (по столбцу published_at добавляется только дата);
2. получить книгу по названию;
3. получить первые 100 книг с количеством страниц меньше 400;
4. получить книги с 101 по 200;
5. получить книги, опубликованные за последние 2 года;
6. получить книги из категорий 'B', 'D', 'E';
7. получить количество книг с количеством страниц больше 2000;
8. получить книги, опубликованные с 2019 по 2022 из категории 'A';
9. получить сумму страниц всех книг;