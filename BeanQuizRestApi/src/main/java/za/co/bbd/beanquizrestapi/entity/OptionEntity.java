package za.co.bbd.beanquizrestapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Option")
@NoArgsConstructor
@Data
public class OptionEntity implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OptionID", unique = true, nullable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "QuestionID", nullable = false)
    private QuestionEntity question;

    @Column(name = "Text", nullable = false)
    private String text;

    @Column(name = "IsCorrect", nullable = false)
    private Boolean isCorrect;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "option")
    private List<UserQuestionResponseEntity> userQuestionResponses;
}
