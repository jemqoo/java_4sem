package com.example.p23.jmx;


import com.example.p23.services.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@ManagedResource
public class MyMBean {

    private final SchedulerService schedulerService;

    @Autowired
    public MyMBean(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @ManagedOperation(description = "Run scheduled task")
    public void run() throws IOException {
        schedulerService.scheduledTask();
    }
}