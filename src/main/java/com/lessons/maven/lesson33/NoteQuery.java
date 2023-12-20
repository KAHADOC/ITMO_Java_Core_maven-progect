package com.lessons.maven.lesson33;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//private long id;
//private String title;
//private String text;
//private ZonedDateTime createdAt;
//private Author author;
public class NoteQuery {
    // DATE
    // TIME
    // TIMESTAMP  дата + время без временной зоны
    // TIMESTAMPZ дата + время + временная зона
    public boolean createTable(){ // SERIAL - INTEGER
        String createSql = "CREATE TABLE IF NOT EXISTS tb_notes(" +
                "id SERIAL PRIMARY KEY, " +
                "title VARCHAR(100) NOT NULL, " +
                "note_text TEXT NOT NULL, " +
                "created_at TIMESTAMPZ NOT NULL, " +
                "author_unique_name VARCHAR(60) NOT NULL, " +
                "CONSTRAINT fk_author_notes " +
                "FOREIGN KEY (author_unique_name) " +
                "REFERENCES tb_authors (unique_name))";
        try (Connection connection = C3p0ConnectionsPool
                .getConnectionFromPool()){
            try (Statement statement = connection.createStatement()){
                statement.executeUpdate(createSql);
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
            // return false;
        }
    }
}
// 1 : 1
// 1 : N
// N : M
// [author_unique_name | note_id] | | | |
//    fafe                1
//    sadfa               1
//    fafe                2
// PRIMARY KEY (author_unique_name, note_id)