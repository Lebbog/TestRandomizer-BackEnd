package RestService.TestRandomizer.controllers;

import RestService.TestRandomizer.Service.QuestionService;
import RestService.TestRandomizer.model.Question;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(QuestionController.BASE_URL)
public class QuestionController {
    public static final String BASE_URL = "api/v1/testrandomizer/questions";
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping
    List<Question> getAllQuestions(){
        return questionService.findAllQuestions();
    }

    @GetMapping("/{id}")
    Question getQuestionById(@PathVariable Long id){
        return questionService.findQuestionById(id);
    }


    @GetMapping("/specific")
    List<Question> getQuestionsByType(@RequestParam(value="subject", defaultValue="Caesar") String subject,
                                      @RequestParam(value="tests", defaultValue="1") int tests,
                                      @RequestParam(value="type", defaultValue="Definition,Multiple Choice") String [] type,
                                      @RequestParam(value="number", defaultValue = "3,3") int [] number){
        System.out.println("Subject: " + subject + "        Tests: " + tests);
        for(int i = 0; i < type.length; i++)
        {
            System.out.println("Type: " + type[i] + "  Number: " + number[i]);
        }
        List<Question> q = new ArrayList();
        return q;
        //return questionService.findQuestionsBySubjectAndType(subject, type);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Question saveQuestion(@RequestBody Question question){
        return questionService.saveQuestion(question);
    }

    @PostMapping("/list")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Question> saveAllQuestions(@RequestBody List<Question> questions){
        return questionService.saveAllQuestions(questions);
    }
}
