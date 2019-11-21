package RestService.TestRandomizer.controllers;

import RestService.TestRandomizer.Service.AuthorService;
import RestService.TestRandomizer.Service.BookService;
import RestService.TestRandomizer.model.Author;
import RestService.TestRandomizer.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AuthorController.BASE_URL)
public class AuthorController {
    public static final String BASE_URL = "api/v1/testrandomizer/authors";
    private final AuthorService authorService;
    private final BookService bookService;
    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }
    @CrossOrigin
    @GetMapping
    List<Author> getAllAuthors(){
        return authorService.findAllAuthors();
    }

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody Author author){
        return authorService.saveAuthor(author);
    }

    @CrossOrigin
    @PostMapping("/list")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Author> saveAllAuthors(@RequestBody List<Author> authors){
        return authorService.saveAllAuthors(authors);
    }

    @CrossOrigin
    @PostMapping("/{authorId}/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@PathVariable(value = "authorId") Long authorId, @RequestBody Book book){
        return bookService.createBook(authorId, book);
    }

    @CrossOrigin
    @DeleteMapping("/{authorId}")
    public void deleteAuthor(@PathVariable(value = "authorId") Long authorId){
         authorService.deleteAuthorById(authorId);
    }
}
