package com.lessons.maven.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainApp {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("lesson36");
        EntityManager manager = factory.createEntityManager();

        // new
        Product product = new Product("title", "description", Product.Category.SPORT);


        manager.getTransaction().begin();
        // managed (persist, merge, find)
        manager.persist(product);
        manager.merge(product);
        manager.getTransaction().commit();

        manager.find(Provider.class, 1);

        // removed / detach
        manager.getTransaction().begin();
        manager.remove(product);
        manager.getTransaction().commit();

        manager.detach(product);


    }
}
