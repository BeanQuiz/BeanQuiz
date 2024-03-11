package za.co.bbd.beanquizrestapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Quiz")
@NoArgsConstructor
@Data
public class QuizEntity implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QuizID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "Title", nullable = false)
    private String title;

    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "TotalQuestions", nullable = false)
    private Integer totalQuestions;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "quiz")
    private List<QuestionEntity> questions;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "quiz")
    private List<UserQuizAttemptEntity> userQuizAttempts;
}
