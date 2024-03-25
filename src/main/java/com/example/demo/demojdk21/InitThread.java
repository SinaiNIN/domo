package com.example.demo.demojdk21;

import com.example.demo.demojdk21.exception.TaskInterruptedException;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class InitThread {
    public long executeAndTimeTasks(ExecutorService executor, String threadType, int numThreads) throws InterruptedException {
        long start = System.nanoTime();
        for (int i = 0; i < numThreads; i++) {
            executor.submit(() -> {
                try {
                    Thread.sleep(Duration.ofSeconds(1));
                } catch (InterruptedException e) {
                    /* Clean up whatever needs to be handled before interrupting  */
                    Thread.currentThread().interrupt();
                    throw new TaskInterruptedException("Task interrupted unexpectedly", e);
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(15, TimeUnit.MINUTES);
        return start;
    }
}
