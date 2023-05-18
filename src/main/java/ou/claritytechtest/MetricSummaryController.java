package ou.claritytechtest;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metricsummary")
public class MetricSummaryController {

    private MetricSummaryService metricSummaryService;

    public MetricSummaryController(MetricSummaryService metricSummaryService) {
        this.metricSummaryService = metricSummaryService;
    }

    @GetMapping
    public MetricSummary getMetricSummary(@RequestParam String system,
                                          @RequestParam(required = false) String name,
                                          @RequestParam(required = false) Integer from,
                                          @RequestParam(required = false) Integer to) {
        return metricSummaryService.getMetricSummary(system, name, from, to);
    }
}
