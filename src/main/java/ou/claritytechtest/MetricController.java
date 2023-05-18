package ou.claritytechtest;

import org.springframework.web.bind.annotation.*;

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
        return metricRepository.save(metric);
    }

    @PutMapping("/{id}")
    public Metric update(@RequestBody Metric metric, @PathVariable int id) {
        if (metric.getId() != id) {
            throw new RuntimeException();
        }
        metricRepository.findById(id).orElseThrow();
        return metricRepository.save(metric);
    }
}
