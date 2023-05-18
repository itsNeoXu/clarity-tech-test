package ou.claritytechtest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/metrics")
public class MetricController {

    private MetricRepository metricRepository;

    public MetricController(MetricRepository metricRepository) {
        this.metricRepository = metricRepository;
    }

    @GetMapping
    public List<Metric> findAll(@RequestParam String system,
                                @RequestParam(required = false) String name,
                                @RequestParam(required = false) Integer from,
                                @RequestParam(required = false) Integer to) {
        return metricRepository.findBySystemAndOptionalParams(system, name, from, to);
    }

    @GetMapping("/{id}")
    public Metric findOne(@PathVariable int id) {
        return metricRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Metric create(@RequestBody Metric metric) {
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

    @PutMapping("/{id}")
    public Metric update(@RequestBody Metric metric, @PathVariable int id) {
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
