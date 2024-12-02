package hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    
    private LocalDate dob;
    
    private String country;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Book> books = new HashSet<>();

    // Constructors, getters, and setters omitted for brevity

    public void addBook(Book book) {
        books.add(book);
        book.setAuthor(this);
    }
}
