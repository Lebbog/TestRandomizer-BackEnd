package RestService.TestRandomizer.Service;

import RestService.TestRandomizer.model.Question;
import org.springframework.stereotype.Service;
import RestService.TestRandomizer.repositories.QuestionRepository;

import java.util.List;

@Service
public class QuestionServiceImpl  implements QuestionService{
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl (QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }
    @Override
    public Question findQuestionById(Long id){
        return questionRepository.findById(id).get();
    }
    @Override
    public List<Question> findAllQuestions(){
        return questionRepository.findAll();
    }
    @Override
    public Question saveQuestion(Question question){
        return questionRepository.save(question);
    }
    @Override
    public List<Question> saveAllQuestions( List<Question> questions){
        return questionRepository.saveAll(questions);
}
    @Override
    public List<Question> findQuestionsBySubjectAndType(String subject, String type){
        return questionRepository.findBySubjectAndType(subject, type);
    }
}
