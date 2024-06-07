package com.cisco.config;

import com.cisco.processor.TownProcessor;
import com.cisco.reader.TownReader;
import com.cisco.repository.DestRepository;
import com.cisco.repository.SourceRepository;
import com.cisco.test.Town;
import com.cisco.writer.TownWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;

import java.util.Objects;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class BatchConfiguration {

    private final SourceRepository sourceRepository;
    private final DestRepository destRepository;
    private final JobRepository jobRepository;
    private final TransactionManager transactionManager;

    @Bean
    public Step step1() {
        return new StepBuilder("step1", jobRepository)
                .<Town, Town>chunk(10, (PlatformTransactionManager) transactionManager)
                .reader(townReader())
                .processor(townProcessor())
                .writer(townWriter())
                .build();
    }

    @Bean
    public Job runJob() {
        return new JobBuilder("Town", jobRepository)
                .start(step1())
                .build();
    }

    @Bean
    public ItemReader townReader() {
        return new TownReader();
    }

    @Bean
    public ItemProcessor townProcessor() {
        return new TownProcessor();
    }

    @Bean
    public ItemWriter townWriter() {
        return new TownWriter();
    }
}
