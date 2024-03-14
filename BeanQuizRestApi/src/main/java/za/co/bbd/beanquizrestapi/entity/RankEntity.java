package za.co.bbd.beanquizrestapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Rank")
@NoArgsConstructor
@Data
public class RankEntity implements IEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RankID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Requirement", nullable = false)
    private Integer requirement;

    @Column(name = "FunFact", nullable = false)
    private String funFact;
}
