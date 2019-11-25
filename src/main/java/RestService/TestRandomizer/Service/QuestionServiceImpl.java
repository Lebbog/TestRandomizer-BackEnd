package RestService.TestRandomizer.Service;

import RestService.TestRandomizer.model.Book;
import RestService.TestRandomizer.model.Question;
import RestService.TestRandomizer.repositories.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import RestService.TestRandomizer.repositories.QuestionRepository;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class QuestionServiceImpl  implements QuestionService{
    private final QuestionRepository questionRepository;
    private final BookRepository bookRepository;
    public QuestionServiceImpl (QuestionRepository questionRepository, BookRepository bookRepository){
        this.questionRepository = questionRepository;
        this.bookRepository = bookRepository;
    }
    @Override
    public Question findQuestionById(Long id){
        return questionRepository.findById(id).get();
    }
    @Override
    public List<Question> findAllQuestions(){
        return questionRepository.findAll();
    }
//    @Override
//    public Question saveQuestion(Question question){
//        return questionRepository.save(question);
//    }
    @Override
    public Question createQuestion(Long bookId, Question question){
        if(!bookRepository.existsById(bookId)){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "bookId " + bookId + " not found"
            );
        }
        else {
            Book book = bookRepository.findById(bookId).get();
            question.setBook(book);
            book.getQuestions().add(question);
            return questionRepository.save(question);
        }
    }
    public void deleteQuestionById(Long questionId){
        if(questionRepository.existsById(questionId)) {
            questionRepository.deleteById(questionId);
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "questionId " + questionId + " not found");
        }
    }
}
//    @Override
//    public List<Question> findQuestionsBySubjectAndType(String subject, String type){
//        return questionRepository.findBySubjectAndType(subject, type);
//    }

