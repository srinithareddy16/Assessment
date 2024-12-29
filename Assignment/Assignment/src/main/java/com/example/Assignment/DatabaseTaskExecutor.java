package com.example.Assignment;
import java.util.concurrent.*;

public class DatabaseTaskExecutor {

    private static final ExecutorService executor = Executors.newFixedThreadPool(10);

    public void performDatabaseTask(Runnable task) {
        executor.submit(task);
    }

    public static void shutdown() {
        executor.shutdown();
    }
}
