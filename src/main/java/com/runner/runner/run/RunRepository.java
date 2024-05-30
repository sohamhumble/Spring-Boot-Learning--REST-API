package com.runner.runner.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private final List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    void create(Run run){
        runs.add(run);
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(1, "Monday Morning Run", LocalDateTime.now(), LocalDateTime.now().plusMinutes((30)), 3, Location.INDOOR));
        runs.add(new Run(2, "Wednesday Evening Run", LocalDateTime.now(), LocalDateTime.now().plusMinutes((60)), 6, Location.INDOOR));
    }

    Optional<Run> findById(int i) {
        return runs.stream().filter(run -> run.id() == i).findFirst();
    }
}
