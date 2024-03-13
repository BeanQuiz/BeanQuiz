package za.co.bbd.beanquizrestapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "UserQuestionResponse")
@NoArgsConstructor
@Data
public class UserQuestionResponseEntity implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ResponseID", unique = true, nullable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AttemptID", nullable = false)
    private UserQuizAttemptEntity attempt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "QuestionID", nullable = false)
    private QuestionEntity question;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SelectedOptionID", nullable = false)
    private OptionEntity option;
}
