package abbah.ahmed.BookSocialNetwork.controller;

import abbah.ahmed.BookSocialNetwork.repository.BookRepository;
import abbah.ahmed.BookSocialNetwork.service.BookService;
import org.springframework.web.bind.annotation.RestController;

@RestController("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }
}
