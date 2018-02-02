package ua.com.owu.run;

import ua.com.owu.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("owu");

        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
            entityManager.persist(new Author("valentin", "picul"));
//            entityManager.persist(new Autor("taras", "shevchenko"));
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }
}