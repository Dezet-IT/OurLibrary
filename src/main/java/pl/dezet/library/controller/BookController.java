package pl.dezet.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.dezet.library.model.Book;
import pl.dezet.library.repository.BookRepository;
import pl.dezet.library.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    BookRepository bookRepository;

    @RequestMapping(path = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Book addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return book;
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getBook() {
        {
            List<Book> list = bookRepository.findAllByOrderByNameAsc();
            return list;
        }
    }
}
