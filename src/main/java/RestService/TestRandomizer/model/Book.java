package RestService.TestRandomizer.model;

import RestService.TestRandomizer.Service.AuthorService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String name;
    @ManyToOne
    @JoinColumn(name = "authorId")
    private Author author;

    @OneToMany(mappedBy = "book")
    private List<Question> questions;
}
