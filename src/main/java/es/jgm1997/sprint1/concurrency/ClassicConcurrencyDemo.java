package es.jgm1997.sprint1.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ClassicConcurrencyDemo {
    private ClassicConcurrencyDemo() {
        throw new IllegalStateException("Utility class");
    }

    public static long runWithFixedThreadPool(int numberOfTasks, int poolSize) throws InterruptedException {
        List<Future<?>> futures = new ArrayList<>();
        long start = System.currentTimeMillis();

        try (var executor = Executors.newFixedThreadPool(poolSize)) {
            for (int i = 0; i < numberOfTasks; i++) {
                futures.add(executor.submit(new ReservationTask(i)));
            }

            for (Future<?> future : futures) {
                try {
                    future.get();
                } catch (ExecutionException e) {
                    // Wrap with a more specific concurrent exception instead of a generic
                    // RuntimeException
                    throw new CompletionException(e.getCause());
                }
            }

            return System.currentTimeMillis() - start;
        }
    }
}
