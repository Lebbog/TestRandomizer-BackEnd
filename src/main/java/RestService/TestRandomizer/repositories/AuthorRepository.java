package RestService.TestRandomizer.repositories;

import RestService.TestRandomizer.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


public interface AuthorRepository extends JpaRepository<Author, Long> {
     void deleteById(Long id);
    //Author findByName(String name);
}