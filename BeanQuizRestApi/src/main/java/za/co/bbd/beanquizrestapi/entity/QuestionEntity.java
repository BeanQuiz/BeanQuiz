package za.co.bbd.beanquizrestapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Question")
@NoArgsConstructor
@Data
public class QuestionEntity implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QuestionID", unique = true, nullable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "QuizID", nullable = false)
    private QuizEntity quiz;

    @Column(name = "Text", nullable = false)
    private String text;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    private List<OptionEntity> options;
}
