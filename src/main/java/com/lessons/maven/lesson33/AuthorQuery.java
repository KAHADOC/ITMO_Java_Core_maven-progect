package com.lessons.maven.lesson33;

import java.sql.*;
import java.time.LocalDate;

public class AuthorQuery {
//    private final String uniqueName;
//    private final LocalDate registeredAt;
//    private boolean isActive = true;

    public boolean createTable(){
                           // DROP TABLE IF EXISTS tb_authors
        String createSql = "CREATE TABLE IF NOT EXISTS tb_authors(" +
                "unique_name VARCHAR(60) PRIMARY KEY, " +
                "registered_at DATE DEFAULT CURRENT_DATE NOT NULL, " +
                "is_active BOOLEAN DEFAULT TRUE)";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        // import java.sql.*
        try (Connection connection = DriverManager.getConnection(
                Lesson33.CONNECTION_STR, Lesson33.LOGIN, Lesson33.PWD
        ))
        {      // Statement | PreparedStatement
               try (Statement statement = connection.createStatement()){
                   try {
                       // для не SELECT запросов
                       statement.executeUpdate(createSql);
                   } catch (SQLException e){
                       System.out.println("Ошибка синтаксиса, " +
                               "отсутствие или наличие таблицы, " +
                               "разрыв соединения");
                       throw new RuntimeException(e);
                   }
               }
        } catch (SQLException e) {
            System.out.println("Ошибка во время соединения с сервером Postgresql");
            throw new RuntimeException(e);
        }
        return true;
    }

    public int insertIntoTable(Author author){
        String insertSQl = "INSERT INTO tb_authors (unique_name) VALUES(?)";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        // import java.sql.*
        try (Connection connection = DriverManager.getConnection(
                Lesson33.CONNECTION_STR, Lesson33.LOGIN, Lesson33.PWD
        ))
        {      // Statement | PreparedStatement
            try (PreparedStatement statement = connection.prepareStatement(insertSQl)){
                statement.setString(1, author.getUniqueName());
                try {
                    // для не SELECT запросов
                    return statement.executeUpdate();
                } catch (SQLException e){
                    System.out.println("Ошибка синтаксиса, " +
                            "отсутствие или наличие таблицы, " +
                            "разрыв соединения");
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException e) {
            System.out.println("Ошибка во время соединения с сервером Postgresql");
            throw new RuntimeException(e);
        }
    }


}















