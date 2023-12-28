package com.lessons.maven.jpa;


import jakarta.persistence.*;

// родитель не является entity классом
// @MappedSuperclass
// родитель является entity классом
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_users")
public class User {
    @Id
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

}

