package RestService.TestRandomizer.controllers;

import RestService.TestRandomizer.Service.BookService;
import RestService.TestRandomizer.Service.QuestionService;
import RestService.TestRandomizer.model.Question;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(QuestionController.BASE_URL)
public class QuestionController {
    public static final String BASE_URL = "api/v1/testrandomizer/questions";
    private final QuestionService questionService;
    private final BookService bookService;
    public QuestionController(QuestionService questionService, BookService bookService){
        this.questionService = questionService;
        this.bookService = bookService;
    }

    @GetMapping
    List<Question> getAllQuestions(){
        return questionService.findAllQuestions();
    }

    @GetMapping("/{id}")
    Question getQuestionById(@PathVariable Long id){
        return questionService.findQuestionById(id);
    }

    @GetMapping("/types")
    List<String> getQuestionTypes() {
        return questionService.getTypes();
    }

    @DeleteMapping("/{questionId}")
    public void deleteBookById(@PathVariable (value = "questionId") Long questionId){
        questionService.deleteQuestionById(questionId);
    }
    @GetMapping("/tests")
    List<List<Question>> createTests( @RequestParam(value="testAmount" ) int testAmount,
                                      @RequestParam(value="bookId") long [] bookId,
                                      @RequestParam(value="type") String [] type,
                                      @RequestParam(value="amount") int [] amount){
        List<List<Question>> tests = new ArrayList();
        while(testAmount-- > 0) {
            List<Question> questions = new ArrayList();
            for (int i = 0; i < bookId.length; i++) {
                System.out.println( "i: " + i );
                //Check if book ID exists
                if(!bookService.existsById(bookId[i])) {
                    throw new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "bookId " + bookId[i] + " not found"
                    );
                }
                List<Question> allQuestions = questionService.findQuestions(bookId[i], type[i]);
                Collections.shuffle(allQuestions);
                for (int j = 0; j < amount[i]; j++) {
                    if(j < allQuestions.size())
                        questions.add(allQuestions.get(j));
                }
            }
            tests.add(questions);
        }
        return tests;
    }

}
