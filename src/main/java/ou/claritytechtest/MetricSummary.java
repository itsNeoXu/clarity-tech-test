package ou.claritytechtest;

public class MetricSummary {

    private String system;
    private String name;
    private Integer from;
    private Integer to;
    private Integer value;

    public MetricSummary(String system, String name, Integer from, Integer to, Integer value) {
        this.system = system;
        this.name = name;
        this.from = from;
        this.to = to;
        this.value = value;
    }

    public String getSystem() {
        return system;
    }

    public String getName() {
        return name;
    }

    public Integer getFrom() {
        return from;
    }

    public Integer getTo() {
        return to;
    }

    public Integer getValue() {
        return value;
    }
}
