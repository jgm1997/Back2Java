package es.jgm1997.sprint1.structured;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;

public class StructuredConcurrencyDemo {
    private StructuredConcurrencyDemo() {
        throw new AssertionError("Utility class");
    }

    public static int runTasks() throws InterruptedException, ExecutionException {

        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {

            var future1 = scope.fork(() -> {
                Thread.sleep(100);
                return 10;
            });

            var future2 = scope.fork(() -> {
                Thread.sleep(150);
                return 20;
            });

            scope.join(); // Wait for all tasks
            scope.throwIfFailed(); // If any task failed, throw

            return future1.get() + future2.get();
        }
    }
}