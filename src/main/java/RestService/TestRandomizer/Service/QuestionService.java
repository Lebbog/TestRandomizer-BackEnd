package RestService.TestRandomizer.Service;

import RestService.TestRandomizer.model.Question;

import java.util.List;


public interface QuestionService {
    Question findQuestionById(Long id);
    List<Question> findAllQuestions();
    Question createQuestion(Long bookId, Question question);
    void deleteQuestionById(Long questionId);
    List<Question> findQuestions(long bookId, String type);
    List<String> getTypes();
//    Question saveQuestion(Question question);
//    List<Question> saveAllQuestions(List<Question> questions);
    //List<Question> findQuestionsBySubjectAndType(String subject, String type);
}
