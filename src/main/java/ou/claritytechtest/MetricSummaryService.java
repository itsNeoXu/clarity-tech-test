package ou.claritytechtest;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricSummaryService {

    private MetricRepository metricRepository;

    public MetricSummaryService(MetricRepository metricRepository) {
        this.metricRepository = metricRepository;
    }

    public MetricSummary getMetricSummary(String system, String name, Integer from, Integer to) {
        List<Metric> metrics = metricRepository.findBySystemAndOptionalParams(system, name, from, to);
        int total = metrics.stream().mapToInt(Metric::getValue).sum();
        return new MetricSummary(system, name, from, to, total);
    }
}
