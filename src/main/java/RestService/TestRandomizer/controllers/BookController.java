package RestService.TestRandomizer.controllers;

import RestService.TestRandomizer.Service.BookService;
import RestService.TestRandomizer.Service.QuestionService;
import RestService.TestRandomizer.model.Book;
import RestService.TestRandomizer.model.Question;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(BookController.BASE_URL)
public class BookController {
    public static final String BASE_URL = "api/v1/testrandomizer/books";
    private final BookService bookService;
    private final QuestionService questionService;
    public BookController(BookService bookService, QuestionService questionService) {
        this.bookService = bookService;
        this.questionService = questionService;
    }
    @GetMapping
    List<Book> getAllBooks(){
        return bookService.findAllBooks();
    }

    @DeleteMapping("/{bookId}")
    public void deleteBookById(@PathVariable (value = "bookId") Long bookId){
        bookService.deleteBookById(bookId);
    }

    @PostMapping("/{bookId}/questions")
    @ResponseStatus(HttpStatus.CREATED)
    public Question createQuestion(@PathVariable(value = "bookId") Long bookId, @RequestBody Question question){
        if(question.getValue() == "" || question.getType() == "") {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Question value and type cannot be empty"
            );
        }
        return questionService.createQuestion(bookId, question);
    }
}