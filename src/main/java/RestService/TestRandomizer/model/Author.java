package RestService.TestRandomizer.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;

    private String name;

    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
