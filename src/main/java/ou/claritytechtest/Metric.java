package ou.claritytechtest;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Metric {

    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true)
    private String system;
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private int date;
    @Column(name = "metric_value")
    private int value;

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
