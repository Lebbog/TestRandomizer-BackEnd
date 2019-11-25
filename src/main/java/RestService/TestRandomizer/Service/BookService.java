package RestService.TestRandomizer.Service;

import RestService.TestRandomizer.model.Book;

import java.util.List;

public interface BookService {
    Book findBookById(Long id);
    List<Book> findAllBooks();
    void deleteBookById(Long bookId);
    Book createBook(Long authorId, Book book);
//    List<Book> saveAllBooks(List<Book> Books);
}
