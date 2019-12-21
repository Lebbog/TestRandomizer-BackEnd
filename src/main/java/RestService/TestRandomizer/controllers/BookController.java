package RestService.TestRandomizer.controllers;

import RestService.TestRandomizer.Service.BookService;
import RestService.TestRandomizer.Service.QuestionService;
import RestService.TestRandomizer.model.Book;
import RestService.TestRandomizer.model.Question;
import RestService.TestRandomizer.repositories.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

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
    @GetMapping("/questionTypes")
    List<Map<String, Object>> getBookTypes(){
        List<Map<String, Object>> bookTypes = new ArrayList();
        List<BookRepository.BookTypes> res = bookService.getTypes();
        for(BookRepository.BookTypes bt : res){
            Long bookId = bt.getBook_id();
            String [] types = bt.getQuestionTypes().split(",");
            Map<String, Object> ent = new HashMap();
            ent.put("Book_Id", bookId);
            ent.put("questionTypes", types);
            bookTypes.add(ent);
        }
        return bookTypes;
        //Arrays.asList(types.split(","))
    }
}