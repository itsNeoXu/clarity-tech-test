package ou.claritytechtest;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metricsummary")
public class MetricSummaryController {

    private MetricRepository metricRepository;

    public MetricSummaryController(MetricRepository metricRepository) {
        this.metricRepository = metricRepository;
    }

    @GetMapping
    public MetricSummary getMetricSummary(@RequestParam String system,
                                          @RequestParam(required = false) String name,
                                          @RequestParam(required = false) Integer from,
                                          @RequestParam(required = false) Integer to) {
        List<Metric> metrics = metricRepository.findBySystemAndOptionalParams(system, name, from, to);
        int total = metrics.stream().mapToInt(Metric::getValue).sum();
        return new MetricSummary(system, name, from, to, total);
    }
}
