package RestService.TestRandomizer.Service;

import RestService.TestRandomizer.model.Author;
import RestService.TestRandomizer.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @Override
    public Author findAuthorById(Long id){
        return authorRepository.findById(id).get();
    }
    @Override
    public List<Author> findAllAuthors(){
        return authorRepository.findAll();
    }
    @Override
    public Author saveAuthor(Author author){
        return authorRepository.save(author);
    }
    @Override
    public List<Author> saveAllAuthors(List<Author> authors){
        return authorRepository.saveAll(authors);
    }
    @Override
    public Author findAuthorByName(String name)
    {
        return authorRepository.findByName(name);
    }
    @Override
    public Author createByName(String name) {
        Author auth = authorRepository.findByName(name);
        if(auth != null) return auth;
        auth  = new Author();
        auth.setName(name);
        return authorRepository.save(auth);
    }
}
