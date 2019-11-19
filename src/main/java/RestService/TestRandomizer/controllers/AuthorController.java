package RestService.TestRandomizer.controllers;

import RestService.TestRandomizer.Service.AuthorService;
import RestService.TestRandomizer.model.Author;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AuthorController.BASE_URL)
public class AuthorController {
    public static final String BASE_URL = "api/v1/testrandomizer/authors";
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping
    List<Author> getAllAuthors(){
        return authorService.findAllAuthors();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody Author author){
        return authorService.saveAuthor(author);
    }

    @PostMapping("/list")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Author> saveAllAuthors(@RequestBody List<Author> authors){
        return authorService.saveAllAuthors(authors);
    }
}
