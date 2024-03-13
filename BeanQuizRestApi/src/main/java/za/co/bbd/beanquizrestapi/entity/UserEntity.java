package za.co.bbd.beanquizrestapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "User")
@Data
public class UserEntity implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "Username", nullable = false)
    private String username;

    @Column(name = "Email", nullable = false)
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<UserQuizAttemptEntity> userQuizAttempts;
}
