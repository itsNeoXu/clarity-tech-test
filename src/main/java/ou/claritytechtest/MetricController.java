package ou.claritytechtest;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metrics")
public class MetricController {

    private MetricService metricService;

    public MetricController(MetricService metricService) {
        this.metricService = metricService;
    }

    @GetMapping
    public List<Metric> findAll(@RequestParam String system,
                                @RequestParam(required = false) String name,
                                @RequestParam(required = false) Integer from,
                                @RequestParam(required = false) Integer to) {
        return metricService.findAll(system, name, from, to);
    }

    @GetMapping("/{id}")
    public Metric findOne(@PathVariable int id) {
        return metricService.findOne(id);
    }

    @PostMapping
    public Metric create(@RequestBody Metric metric) {
        return metricService.create(metric);
    }

    @PutMapping("/{id}")
    public Metric update(@RequestBody Metric metric, @PathVariable int id) {
        return metricService.update(metric, id);
    }
}
