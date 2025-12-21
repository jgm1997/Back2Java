package es.jgm1997.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ClassicConcurrencyDemo {
    private ClassicConcurrencyDemo() {
        throw new IllegalStateException("Utility class");
    }
    public static long runWithFixedThreadPool(int numberOfTasks, int poolSize) throws InterruptedException {
        ExecutorService executor = null;
        List<Future<?>> futures = new ArrayList<>();
        long start = System.currentTimeMillis();
        InterruptedException interrupted = null;
        long elapsed;

        try {
            executor = Executors.newFixedThreadPool(poolSize);

            for (int i = 0; i < numberOfTasks; i++) {
                futures.add(executor.submit(new ReservationTask(i)));
            }

            for (Future<?> future : futures) {
                try {
                    future.get();
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }

            elapsed = System.currentTimeMillis() - start;
        } finally {
            if (executor != null) {
                executor.shutdown();
                try {
                    if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                        executor.shutdownNow();
                    }
                } catch (InterruptedException e) {
                    executor.shutdownNow();
                    Thread.currentThread().interrupt();
                    interrupted = e;
                }
            }
        }

        if (interrupted != null) {
            throw interrupted;
        }
        return elapsed;
    }
}
