package mta.demo.services;

import mta.demo.entities.Book;
import mta.demo.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> list() {
        return bookRepository.findAll();
    }

    public Long count() { return bookRepository.count(); }

    public Book newBook(Book book) {
        book.setId(null);
        return bookRepository.save(book);
    }

    public Book getById(Long id){ return bookRepository.getById(id); }

    public List <Book> getByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List <Book> getByContainsTitle(String title) {
        return bookRepository.findByTitleContaining(title);
    }

    public List <Book> getAllBooksByPublisherId(Long id) {
        return bookRepository.findByPublisher_id(id);
    }
}
