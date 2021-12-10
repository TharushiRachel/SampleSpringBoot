package com.example.SampleSpringBoot.scheduler;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
@EnableScheduling
public class Scheduler {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("YY/MM/DD");

    @Scheduled(cron = "*/5 * * * * *")
    public void scheduleTaskUsingCronExpression() {

        long now = System.currentTimeMillis() / 1000;
        System.out.println(
                "schedule tasks using cron jobs - " + now);
    }
}
