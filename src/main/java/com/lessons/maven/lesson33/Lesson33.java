package com.lessons.maven.lesson33;

import java.time.LocalDate;

public class Lesson33 {
    public static final String CONNECTION_STR =
            "jdbc:postgresql://localhost:5432/db_name";
    public static final String LOGIN = "username";
    public static final String PWD = "password";

    public static void main(String[] args) {

        // установить соединение
        // отправить запрос
        // закрыть соединение

        // public Author(String uniqueName, LocalDate registeredAt, boolean isActive)
        AuthorQuery authorQuery = new AuthorQuery();
        authorQuery.createTable();
        Author author = new Author("author02");
        authorQuery.insertIntoTable(author);
    }
}
