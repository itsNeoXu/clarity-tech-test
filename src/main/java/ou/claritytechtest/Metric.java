package ou.claritytechtest;


import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"system", "name", "date"}))
public class Metric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String system;
    private String name;
    private Integer date;
    @Column(name = "metric_value")
    private Integer value;

    public int getId() {
        return id;
    }

    public String getSystem() {
        return system;
    }

    public String getName() {
        return name;
    }

    public int getDate() {
        return date;
    }

    public int getValue() {
        return value;
    }
}
