package RestService.TestRandomizer.Service;

import RestService.TestRandomizer.model.Author;

import java.util.List;

public interface AuthorService {
    Author findAuthorById(Long id);
    List<Author> findAllAuthors();
    Author saveAuthor(Author author);
    List<Author> saveAllAuthors(List<Author> authors);
    void deleteAuthorById(long id);
}
