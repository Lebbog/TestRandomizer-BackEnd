package RestService.TestRandomizer.repositories;

import RestService.TestRandomizer.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Long> {

    //get distinct type of questions that belong to this book
    @Query(value = "select a.book_id, GROUP_CONCAT(distinct b.type) as questionTypes from book as a inner join question as b on a.book_id = b.book_id group by book_id;",
            nativeQuery = true)
    List<BookTypes> getTypes();

    public interface BookTypes {
        long getBook_id();
        String getQuestionTypes();
    }
}