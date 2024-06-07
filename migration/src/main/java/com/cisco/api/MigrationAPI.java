package com.cisco.api;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/migration")
@RequiredArgsConstructor
public class MigrationAPI {

    private static final Logger log = LoggerFactory.getLogger(MigrationAPI.class);
    private final Job job;
    private final JobLauncher jobLauncher;

    @GetMapping
    public String migration() {
        try {
            jobLauncher.run(job, new JobParameters());
        } catch (Exception e) {
            log.error("ERROR RUNNING JOB:{}", e.getMessage());
        }
        return "SUCCESS";
    }
}
