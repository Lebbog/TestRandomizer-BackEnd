package RestService.TestRandomizer.repositories;

import RestService.TestRandomizer.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}