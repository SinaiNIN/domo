package com.example.demo.demojdk21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class InitThreadTest {
    private InitThread initThread;
    private static final int THREAD_NUMBER = 30;
    private static final int MAX_THREAD_PER_POOL = 10;

    @BeforeEach
    void setUp() {
        initThread = new InitThread();
    }

    @Test
    void testVirtualThreadPerTaskExecutor() throws InterruptedException {
        long start;
        String VIRTUAL_THREAD = "Virtual Threads";
        start = initThread.executeAndTimeTasks(Executors.newVirtualThreadPerTaskExecutor(), VIRTUAL_THREAD, THREAD_NUMBER);

        long duration = Duration.ofNanos(System.nanoTime() - start).toMillis();
        System.out.println("Duration is : " + duration);
        assertTrue(duration < 3000, VIRTUAL_THREAD + "take less than 3000 ms");
    }

    @Test
    void testStartVirtualThread() throws InterruptedException {
        long start;
        String VIRTUAL_THREAD = "Virtual Threads";
        start = initThread.executeTasksWithVirtualThead(THREAD_NUMBER);

        long duration = Duration.ofNanos(System.nanoTime() - start).toMillis();
        System.out.println("Duration is : " + duration);
        assertTrue(duration < 3000, VIRTUAL_THREAD + "take less than 3000 ms");
    }

    @Test
    void testOfVirtualThread() throws InterruptedException {
        long start;
        String VIRTUAL_THREAD = "Virtual Threads";
        start = initThread.executeTasksWithOfVirtualThead(THREAD_NUMBER);

        long duration = Duration.ofNanos(System.nanoTime() - start).toMillis();
        System.out.println("Duration is : " + duration);
        assertTrue(duration < 3000, VIRTUAL_THREAD + "take less than 3000 ms");
    }

    @Test
    void testPlatformTheadWithFixedThreadPool() throws InterruptedException {
        long start;
        String FIXED_THREAD_POOL = "Fixed Thread Pool";
        start = initThread.executeAndTimeTasks(Executors.newFixedThreadPool(MAX_THREAD_PER_POOL), FIXED_THREAD_POOL, THREAD_NUMBER);

        long duration = Duration.ofNanos(System.nanoTime() - start).toMillis();
        System.out.println("Duration is : " + duration);
        assertTrue(duration < 5000, FIXED_THREAD_POOL + "take more than 5000 ms");
    }

    @Test
    void testPlatformTheadWithThreadPool() throws InterruptedException {
        long start;
        String CACHED_THREAD_POOL = "Thread Pool";
        start = initThread.executeTasksWithPlatformThread(THREAD_NUMBER);

        long duration = Duration.ofNanos(System.nanoTime() - start).toMillis();
        System.out.println("Duration is : " + duration);
        assertTrue(duration < 3000, CACHED_THREAD_POOL + "take less than 3000 ms");
    }

}