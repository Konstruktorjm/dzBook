package ua.com.owu.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "autor")
    List<Book> books = new ArrayList<Book>();

    private String nameAutor;
    private String lastNameAutor;

    public Author(String nameAutor, String lastNameAutor) {
        this.nameAutor = nameAutor;
        this.lastNameAutor = lastNameAutor;
    }

    public Author() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getNameAutor() {
        return nameAutor;
    }

    public void setNameAutor(String nameAutor) {
        this.nameAutor = nameAutor;
    }

    public String getLastNameAutor() {
        return lastNameAutor;
    }

    public void setLastNameAutor(String lastNameAutor) {
        this.lastNameAutor = lastNameAutor;
    }
}
