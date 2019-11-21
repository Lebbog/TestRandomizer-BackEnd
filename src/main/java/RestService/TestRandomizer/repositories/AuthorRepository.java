package RestService.TestRandomizer.repositories;

import RestService.TestRandomizer.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AuthorRepository extends JpaRepository<Author, Long> {
     void deleteById(Long id);
    //Author findByName(String name);
}