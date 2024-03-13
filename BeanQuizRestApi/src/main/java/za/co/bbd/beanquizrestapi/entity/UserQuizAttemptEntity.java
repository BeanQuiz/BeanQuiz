package za.co.bbd.beanquizrestapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "UserQuizAttempt")
@NoArgsConstructor
@Data
public class UserQuizAttemptEntity implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AttemptID", unique = true, nullable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserID", nullable = false)
    private UserEntity user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "QuizID", nullable = false)
    private QuizEntity quiz;

    @Column(name = "StartTimestamp", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTimestamp;

    @Column(name = "EndTimestamp", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTimestamp;

    @Column(name = "Score", nullable = false)
    private Integer score;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "attempt")
    private List<UserQuestionResponseEntity> userQuestionResponses;
}
