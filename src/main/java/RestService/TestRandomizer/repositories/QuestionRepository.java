package RestService.TestRandomizer.repositories;

import RestService.TestRandomizer.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin()
public interface QuestionRepository extends JpaRepository<Question, Long>{
    //List<Question> findBySubjectAndType(String subject, String type);
}