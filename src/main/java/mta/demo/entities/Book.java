package mta.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;


@Entity
@Table(name = "books", indexes = @Index(columnList = "isbn"))
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Book implements Serializable {

    @Id
    @Column(name = "book_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 13)
    private String isbn;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "author", nullable = false)
    private Author author;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "publisher", nullable = false)
    private Publisher publisher;

    @Max(2100)
    @Min(1000)
    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, precision = 2)
    private Float price;

    /* GETTERS & SETTERS */

    public Long getId() { return id; }
    public void setId(Long Id) { this.id = id; }

    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }

    public Publisher getPublisher() { return publisher; }
    public void setPublisher(Publisher publisher) { this.publisher = publisher; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public Integer getYear() {  return year;  }
    public void setYear(Integer year) { this.year = year;  }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Float getPrice() { return price; }
    public void setPrice(Float price) { this.price = price; }

    /* TO STRING */

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + id +
                ", author=" + author +
                ", publisher=" + publisher +
                ", year=" + year +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
