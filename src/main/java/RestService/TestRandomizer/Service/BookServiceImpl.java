package RestService.TestRandomizer.Service;

import RestService.TestRandomizer.model.Author;
import RestService.TestRandomizer.model.Book;
import RestService.TestRandomizer.repositories.AuthorRepository;
import RestService.TestRandomizer.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService{

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }
    @Override
    public Book findBookById(Long id){
        return bookRepository.findById(id).get();
    }
    @Override
    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }
    @Override
    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    @Override
    public Book createBook(Long authorId, Book book){
        Author auth = authorRepository.findById(authorId).get();
        if(auth == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "authorId not found"
            );
        }
        book.setAuthor(auth);
        auth.getBooks().add(book);
        return bookRepository.save(book);
    }
//    @Override
//    public List<Book> saveAllBooks(List<Book> books){
//        return bookRepository.saveAll(books);
//    }
}
