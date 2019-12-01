package RestService.TestRandomizer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    private String type;
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId")
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Book book;

    public Long getBookId(){
        return book.getBookId();
    }
    public String getBookTitle(){
        return book.getTitle();
    }
    public String getAuthorName(){
        return book.getAuthorName();
    }
}
