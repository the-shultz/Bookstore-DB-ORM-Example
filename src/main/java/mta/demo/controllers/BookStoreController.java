package mta.demo.controllers;

import mta.demo.entities.Author;
import mta.demo.entities.Book;
import mta.demo.entities.Publisher;
import mta.demo.services.AuthorService;
import mta.demo.services.BookService;
import mta.demo.services.PublisherService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/bookstore")
public class BookStoreController {

    private final BookService bookService;

    private final PublisherService publisherService;

    private final AuthorService authorService;

    public BookStoreController(BookService bookService, PublisherService publisherService, AuthorService authorService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

    @GetMapping(value = "/")
    @ResponseBody
    public HashMap <String, Long> getCount()
    {
        HashMap <String, Long> counts = new HashMap<>();
        counts.put("Books", bookService.count());
        counts.put("Authors", authorService.count());
        counts.put("Publishers", publisherService.count());
        return counts;
    }

    @GetMapping(value = "/books")
    @ResponseBody
    public List<Book> getAllBooks()
    {
        return bookService.list();
    }

    @GetMapping(value = "/publishers")
    @ResponseBody
    public List<Publisher> getAllPublishers()
    {
        return publisherService.list();
    }

    @GetMapping(value = "/authors")
    @ResponseBody
    public List<Author> getAllAuthors()
    {
        return authorService.list();
    }

    @PostMapping("/book")
    @ResponseBody
    public Book saveNewBook(@RequestBody Book book)
    {
        return bookService.newBook(book);
    }

    @GetMapping("/book/{id}")
    @ResponseBody
    public Book getBookById(@PathVariable Long id)
    {
        return bookService.getById(id);
    }

    @GetMapping("/books/{title}")
    @ResponseBody
    public List <Book> getBookByTitle(@PathVariable String title)
    {
        return bookService.getByTitle(title);
    }

    @GetMapping("/books/find")
    @ResponseBody
    public List <Book> getBookContainsTitle(@RequestParam String title)
    {
        return bookService.getByContainsTitle(title);
    }

    @GetMapping("/publisher/{id}")
    @ResponseBody
    public Publisher getPublisherById(@PathVariable Long id)
    {
        return publisherService.getById(id);
    }

    @GetMapping("/publisher/{id}/books")
    @ResponseBody
    public List<Book> getPublisherBooks(@PathVariable Long id)
    {
        return bookService.getAllBooksByPublisherId(id);
    }

}
