package RestService.TestRandomizer.repositories;

import RestService.TestRandomizer.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


public interface QuestionRepository extends JpaRepository<Question, Long>{
    @Query(value = "SELECT q FROM Question q WHERE q.book.bookId= ?1 AND q.type= ?2")
    List<Question> findQuestions(long bookId, String type);

    @Query(value = "SELECT distinct type FROM question", nativeQuery = true)
        List<String> getTypes();
}