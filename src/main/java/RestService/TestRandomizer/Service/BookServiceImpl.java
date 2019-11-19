package RestService.TestRandomizer.Service;

import RestService.TestRandomizer.model.Book;
import RestService.TestRandomizer.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
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
    public List<Book> saveAllBooks(List<Book> books){
        return bookRepository.saveAll(books);
    }
}
