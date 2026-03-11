package com.example.file;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component

public class Schedule
{
    @Scheduled(cron="45 46 13 * * ?")
public void hello(){
    System.out.println("Hello");
}
}
