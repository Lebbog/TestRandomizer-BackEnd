package RestService.TestRandomizer.controllers;

import RestService.TestRandomizer.Service.AuthorService;
import RestService.TestRandomizer.Service.BookService;
import RestService.TestRandomizer.model.Author;
import RestService.TestRandomizer.model.Book;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
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
//    @CrossOrigin
    @GetMapping
    List<Author> getAllAuthors(){
        return authorService.findAllAuthors();
    }

//    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody Author author){
        if(author.getName() == "") {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Author name cannot be empty"
            );
        }
        return authorService.saveAuthor(author);
    }

//    @CrossOrigin
//    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
//        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
//    @ResponseStatus(HttpStatus.CREATED)
//    public Author saveAuthor(@RequestParam MultiValueMap  body){
//        System.out.println(body.get("name"));
//        return null;
//    }
//    @CrossOrigin
    @PostMapping("/list")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Author> saveAllAuthors(@RequestBody List<Author> authors){
        return authorService.saveAllAuthors(authors);
    }

//    @CrossOrigin
    @PostMapping("/{authorId}/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@PathVariable(value = "authorId") Long authorId, @RequestBody Book book){
        return bookService.createBook(authorId, book);
    }
    @DeleteMapping("/{authorId}")
    public void deleteAuthor(@PathVariable (value = "authorId") Long authorId){
         authorService.deleteAuthorById(authorId);
    }
}
