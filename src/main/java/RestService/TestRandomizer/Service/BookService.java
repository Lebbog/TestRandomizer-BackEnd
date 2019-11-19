package RestService.TestRandomizer.Service;

import RestService.TestRandomizer.model.Book;

import java.util.List;

public interface BookService {
    Book findBookById(Long id);
    List<Book> findAllBooks();
    Book saveBook(Book Book);
    List<Book> saveAllBooks(List<Book> Books);
}
