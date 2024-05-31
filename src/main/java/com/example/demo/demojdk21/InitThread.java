package com.example.demo.demojdk21;

import com.example.demo.demojdk21.exception.TaskInterruptedException;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class InitThread {
    public long executeAndTimeTasks(ExecutorService executor, String threadType, int numThreads) throws InterruptedException {
        long start = System.nanoTime();
        for (int i = 0; i < numThreads; i++) {
            int finalI = i;
            executor.submit(() -> {
                try {
                    isEventNumber(finalI);
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

    public long executeTasksWithVirtualThead(int numThreads) throws InterruptedException {
        long start = System.nanoTime();
        int finalI = 0;
        for (int i = 0; i < numThreads; i++) {
            finalI = i;
            Thread.startVirtualThread(() -> {
                try {
                    Thread.sleep(Duration.ofSeconds(1));
                } catch (InterruptedException e) {
                    /* Clean up whatever needs to be handled before interrupting */
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Task interrupted unexpectedly", e);
                }
            });
        }
        Thread.sleep(Duration.ofSeconds(2));
        System.out.println("Number of loops: " + finalI);
        return start;
    }

    public long executeTasksWithOfVirtualThead(int numThreads) throws InterruptedException {
        long start = System.nanoTime();
        int finalI = 0;
        for (int i = 0; i < numThreads; i++) {
            finalI = i;
            Thread.ofVirtual().start(() -> {
                try {
                    Thread.sleep(Duration.ofSeconds(1));
                } catch (InterruptedException e) {
                    /* Clean up whatever needs to be handled before interrupting */
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Task interrupted unexpectedly", e);
                }
            });
        }
        Thread.sleep(Duration.ofSeconds(2));
        System.out.println("Number of loops: " + finalI);
        return start;
    }

    public long executeTasksWithPlatformThread(int numThreads) throws InterruptedException {
        long start = System.nanoTime();
        int finalI = 0;
        for (int i = 0; i < numThreads; i++) {
            finalI = i;
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(Duration.ofSeconds(1)); // equivalent to Duration.ofSeconds(1)
                } catch (InterruptedException e) {
                    /* Clean up whatever needs to be handled before interrupting */
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Task interrupted unexpectedly", e);
                }
            });
            thread.start();
        }

        Thread.sleep(Duration.ofSeconds(2)); // equivalent to Duration.ofSeconds(2)
        System.out.println("Number of loops: " + finalI);
        return start;
    }

    private Boolean isEventNumber(int i){
        return (i % 2 == 0);
    }
}
