package com.lessons.maven.jpa;

import jakarta.persistence.*;


@Entity // product
@Table(name = "tb_products") // описание таблицы
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    //@Column(nullable = false, length = 1000,
    // columnDefinition = "TEXT NOT NULL") // описание столбца
    @Column(nullable = false, length = 1000) // описание столбца
    private String description;

    // EnumType.ORDINAL;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "product_category", nullable = false)
    private Category category;

    public Product(){}

    public Product(String title, String description, Category category) {
        this.title = title;
        this.description = description;
        this.category = category;
    }

    public enum Category{
        SPORT, HOME, STUDY
    }
}

