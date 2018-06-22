package pl.dezet.library.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.dezet.library.model.Book;
import pl.dezet.library.repository.BookRepository;
import pl.dezet.library.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;
    private Logger logger;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    BookRepository bookRepository;

    @RequestMapping(path = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addTransit(@RequestBody Book book) {
        bookService.addBook(book);
        System.out.println(book);
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getBook(Model model) {
        {
            model.addAttribute("books", bookRepository.findAll());
            return "book/list";
        }
    }
}
