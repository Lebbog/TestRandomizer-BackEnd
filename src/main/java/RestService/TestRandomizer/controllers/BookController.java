package RestService.TestRandomizer.controllers;

import RestService.TestRandomizer.Service.BookService;
import RestService.TestRandomizer.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(BookController.BASE_URL)
public class BookController {
    public static final String BASE_URL = "api/v1/testrandomizer/books";
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    List<Book> getAllBooks(){
        return bookService.findAllBooks();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book saveBook(@RequestBody Book book){
        //System.out.println(book);
        String authName = book.getAuthorName();
        return bookService.createBook(authName, book);
    }

//    @PostMapping("/list")
//    @ResponseStatus(HttpStatus.CREATED)
//    public List<Book> saveAllBooks(@RequestBody List<Book> books){
//        return bookService.saveAllBooks(books);
//    }
}