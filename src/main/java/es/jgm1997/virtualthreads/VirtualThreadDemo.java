package es.jgm1997.virtualthreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class VirtualThreadDemo {
    private VirtualThreadDemo() {
        // Use AssertionError for utility classes to indicate non-instantiability
        throw new AssertionError("Utility class");
    }

    public static long runWithVirtualThreads(int numberOfTasks) throws InterruptedException {
        List<Future<?>> futures = new ArrayList<>();
        long start = System.currentTimeMillis();

        // Use try-with-resources to ensure the executor is closed when possible
        try (var executorService = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 0; i < numberOfTasks; i++) {
                futures.add(executorService.submit(new VirtualReservationTask(i)));
            }

            for (Future<?> future : futures) {
                try {
                    future.get();
                } catch (ExecutionException e) {
                    // Wrap with a more specific concurrent exception instead of a generic RuntimeException
                    throw new CompletionException(e.getCause());
                }
            }

            return System.currentTimeMillis() - start;
        }
    }
}
