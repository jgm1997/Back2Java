package es.jgm1997.virtualthreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class VirtualThreadDemo {
    public static long runWithVirtualThreads(int numberOfTasks) throws InterruptedException {
        ExecutorService executorService = null;
        List<Future<?>> futures = new ArrayList<>();
        long start = System.currentTimeMillis();

        try {
            executorService = Executors.newVirtualThreadPerTaskExecutor();

            for (int i = 0; i < numberOfTasks; i++) {
                futures.add(executorService.submit(new VirtualReservationTask(i)));
            }

            for (Future<?> future : futures) {
                try {
                    future.get();
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }

            return System.currentTimeMillis() - start;
        } finally {
            if (executorService != null) {
                executorService.shutdown();
                try {
                    if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                        executorService.shutdownNow();
                    }
                } catch (InterruptedException e) {
                    executorService.shutdownNow();
                    Thread.currentThread().interrupt();
                    throw e;
                }
            }
        }
    }
}
