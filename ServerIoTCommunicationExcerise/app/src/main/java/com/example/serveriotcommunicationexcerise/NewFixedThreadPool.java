package com.example.serveriotcommunicationexcerise;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewFixedThreadPool {
    private static ExecutorService executorService;

    public Executor getThreadPool() {
        if (executorService == null) {
            executorService = Executors.newFixedThreadPool(10);
        }

        return executorService;
    }
}
