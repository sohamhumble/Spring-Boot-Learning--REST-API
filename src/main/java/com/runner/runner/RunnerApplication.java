package com.runner.runner;

import com.runner.runner.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static com.runner.runner.run.Location.OUTDOOR;

@SpringBootApplication
public class RunnerApplication {
    private static final Logger log = LoggerFactory.getLogger(RunnerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RunnerApplication.class, args);
        System.out.println("Reloaded at "+LocalTime.now());
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            Run run = new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, OUTDOOR);
            log.info("Run: {}", run);
        };
    }

}
