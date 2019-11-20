package RestService.TestRandomizer.Service;

import RestService.TestRandomizer.model.Author;
import RestService.TestRandomizer.model.Book;
import RestService.TestRandomizer.repositories.AuthorRepository;
import RestService.TestRandomizer.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Book createBook(String authorName, Book book){
        //Set<Book> bks = new HashSet();
        Author auth = authorRepository.findByName(authorName);
        if(auth == null) {
            auth = new Author();
            auth.setName(authorName);
            auth = authorRepository.save(auth);
        }
        List<Book> books = bookRepository.findByTitle(book.getTitle());
        for (Book b : books) {
            if(b.getAuthor().getName().equals(authorName)) {
                return b;
            }
        }
        book.setAuthor(auth);
        Book book1 = bookRepository.save(book);
        //bks.add(book1);
        //auth.setBooks(bks);

        auth.getBooks().add(book1);
        return book1;
    }
//    @Override
//    public List<Book> saveAllBooks(List<Book> books){
//        return bookRepository.saveAll(books);
//    }
}
