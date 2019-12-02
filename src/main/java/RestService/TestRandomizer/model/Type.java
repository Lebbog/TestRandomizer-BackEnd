//package RestService.TestRandomizer.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@Data
//@Entity
//public class Type {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long typeId;
//
//    private String type;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    @EqualsAndHashCode.Exclude
//    private Set<Question> questions = new HashSet<>();
//}
