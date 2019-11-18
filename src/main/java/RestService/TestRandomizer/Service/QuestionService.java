package RestService.TestRandomizer.Service;

import RestService.TestRandomizer.model.Question;

import java.util.List;


public interface QuestionService {
    Question findQuestionById(Long id);
    List<Question> findAllQuestions();
    Question saveQuestion(Question question);
    List<Question> saveAllQuestions(List<Question> questions);
    List<Question> findQuestionsBySubjectAndType(String subject, String type);
}
