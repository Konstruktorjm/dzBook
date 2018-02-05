package ua.com.owu.run;

import ua.com.owu.entity.Author;
import ua.com.owu.entity.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.PreferenceChangeListener;

public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("owu");

        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

//            entityManager.persist(new Author("valentin", "picul"));
//            entityManager.persist(new Author("taras", "shevchenko"));
//            entityManager.persist(new Author("fedor", "dostoevskiy"));


//        List<Book> books = new ArrayList<Book>();
//        books.add(new Book("каторга","о каторге на островах Курильской гряды.", 1986));
//        books.add(new Book("пером и шпагой", "об эпохе правления императрицы Анны Иоанновны.",1972));
//        books.add(new Book("гайдамаки", "воспевает народное движение XVIII века",1841));
//        books.add(new Book("преступление и наказание", "не простые отношения Коли и бабки)))",1866));


//        Author author1 = entityManager.find(Author.class, 1);
//        Author author2 = entityManager.find(Author.class, 2);
//        Author author3 = entityManager.find(Author.class, 3);
//            author1.setBooks(books);

//
//        List<Book> books = entityManager.createQuery("from Book p", Book.class).getResultList();
//        for (Book book : books) {
//            if(book.getId() == 1){
//                book.setAuthor(author1);
//            }
//            if(book.getId() == 2){
//                book.setAuthor(author1);
//            }
//            if(book.getId() == 3){
//                book.setAuthor(author2);
//            }
//            else if(book.getId() == 4){
//                book.setAuthor(author3);
//            }
//        }
//
        List<Book> resultList = entityManager.createQuery("from Book b", Book.class).getResultList();
            for (int i = 0; i < resultList.size(); i++ ){
                System.out.println(resultList.get(i));
            }

        System.out.println("**********************************************");

        List<Author> authorList = entityManager.createQuery("from Author a", Author.class).getResultList();
            for (int i = 0; i < authorList.size(); i++ ){
                System.out.println(authorList.get(i));
            }

        System.out.println("**********************************************");

        List picul = entityManager.createQuery("from Book b where b.id <= 2").getResultList();
        for (int i = 0; i < picul.size(); i++ ){
            System.out.println(picul.get(i));
        }

        System.out.println("**********************************************");

        List<Author> authorModification = entityManager.createQuery("from Author a where id = 3", Author.class)
                                        .getResultList();
        for (Author author : authorModification) {
            author.setNameAuthor("Лев");
            author.setLastNameAuthor("Толстой");
        }
        System.out.println(authorModification);

        System.out.println("**********************************************");

        List<Book> bookModification = entityManager.createQuery("from Book b where b.id = 3", Book.class)
                .getResultList();
        for (Book bookMod : bookModification) {
            bookMod.setTitleBook("Война и мир");
            bookMod.setDescriptionBook("мокшансое общество в эпоху войн(постоянная эпоха) против Наполеона");
            bookMod.setYearOfPublishing(1867);
            bookMod.getAuthor().setNameAuthor("lev");
            bookMod.getAuthor().setLastNameAuthor("Tolstoy");
        }
        System.out.println(bookModification);

        System.out.println("**********************************************");

//        TypedQuery<Book> query = entityManager.createQuery("from Book b where b.id = 4", Book.class);

//        entityManager::remove("from Book b where b.id = 4", Book.class);


        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }
}