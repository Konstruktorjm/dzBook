package ua.com.owu.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String titleBook;
    private String descriptionBook;
    private int yearOfPublishing;

    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Author autor;

    public Book(String titleBook, String descriptionBook, int yearOfPublishing) {
        this.titleBook = titleBook;
        this.descriptionBook = descriptionBook;
        this.yearOfPublishing = yearOfPublishing;


    }


    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }

    public String getDescriptionBook() {
        return descriptionBook;
    }

    public void setDescriptionBook(String descriptionBook) {
        this.descriptionBook = descriptionBook;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public Author getAutor() {
        return autor;
    }

    public void setAutor(Author autor) {
        this.autor = autor;
    }
}
