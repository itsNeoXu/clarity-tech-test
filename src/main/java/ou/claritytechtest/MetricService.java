package ou.claritytechtest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MetricService {

    private MetricRepository metricRepository;

    public MetricService(MetricRepository metricRepository) {
        this.metricRepository = metricRepository;
    }

    public List<Metric> findAll(String system, String name, Integer from, Integer to) {
        return metricRepository.findBySystemAndOptionalParams(system, name, from, to);
    }

    public Metric findOne(int id) {
        return metricRepository.findById(id).orElseThrow();
    }

    public Metric create(Metric metric) {
        if (StringUtils.isBlank(metric.getSystem())) {
            throw new RuntimeException("system cannot be blank");
        }
        if (StringUtils.isBlank(metric.getName())) {
            throw new RuntimeException("name cannot be blank");
        }
        if (metric.getDate() == null) {
            Date date = new Date();
            long unixTime = date.getTime() / 1000L;
            metric.setDate((int) unixTime);
        }
        if (metric.getValue() == null) {
            metric.setValue(1);
        }
        return metricRepository.save(metric);
    }

    public Metric update(Metric metric, int id) {
        if (metric.getId() != id) {
            throw new RuntimeException("Metric id " + metric.getId() + " does not match provided path id " + id);
        }
        if (StringUtils.isBlank(metric.getSystem())) {
            throw new RuntimeException("system cannot be blank");
        }
        if (StringUtils.isBlank(metric.getName())) {
            throw new RuntimeException("name cannot be blank");
        }
        if (metric.getDate() == null) {
            throw new RuntimeException("date cannot be blank");
        }
        Metric foundMetric = metricRepository.findById(id).orElseThrow();
        if (metric.getValue() == null) {
            metric.setValue(foundMetric.getValue() + 1);
        }
        return metricRepository.save(metric);
    }
}
