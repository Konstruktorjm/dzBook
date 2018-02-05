package ua.com.owu.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String titleBook;
    private String descriptionBook;
    private int yearOfPublishing;

    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Author author;

    public Book(String titleBook, String descriptionBook, int yearOfPublishing) {
        this.titleBook = titleBook;
        this.descriptionBook = descriptionBook;
        this.yearOfPublishing = yearOfPublishing;
    }
}
