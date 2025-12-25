package es.jgm1997.sprint1.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    private CompletableFutureDemo() {
        throw new IllegalStateException("Utility class");
    }

    public static long runWithCompletableFuture(int numberOfTasks) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        long start = System.currentTimeMillis();

        for (int i = 0; i < numberOfTasks; i++) {
            futures.add(CompletableFuture.runAsync(new ReservationTask(i)));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        return System.currentTimeMillis() - start;
    }
}
