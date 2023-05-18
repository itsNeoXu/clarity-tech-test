package ou.claritytechtest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MetricRepository extends JpaRepository<Metric, Integer> {

    @Query("SELECT m FROM Metric m WHERE m.system = :system AND " +
            "(:name IS NULL OR m.name = :name) AND " +
            "(:from IS NULL OR m.date >= :from) AND " +
            "(:to IS NULL OR m.date < :to)")
    List<Metric> findBySystemAndOptionalParams(
            @Param("system") String system,
            @Param("name") String name,
            @Param("from") Integer from,
            @Param("to") Integer to);
}
