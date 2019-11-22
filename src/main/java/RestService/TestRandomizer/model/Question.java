package RestService.TestRandomizer.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    private String type;
    private String value;
    //private String subject;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;
}
