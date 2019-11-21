package RestService.TestRandomizer.repositories;

import RestService.TestRandomizer.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin()
public interface BookRepository extends JpaRepository<Book, Long> {

//    @Query(value = "SELECT b FROM Book b WHERE b.author.authorId= ?1 AND b.title= ?2")
//    Book findByTitleAndAuthorId(long authorId, String title);
}