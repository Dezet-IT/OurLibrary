package pl.dezet.library.controller;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.dezet.library.model.Book;
import pl.dezet.library.service.BookService;

@RestController
public class BookController {
    private BookService bookService;
    private Logger logger;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(path = "/book", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addTransit(@RequestBody Book book) {
        bookService.addBook(book);
        System.out.println(book);
    }
}
