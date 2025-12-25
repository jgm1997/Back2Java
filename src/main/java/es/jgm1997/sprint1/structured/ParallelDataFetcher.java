package es.jgm1997.sprint1.structured;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;

public class ParallelDataFetcher {
    private ParallelDataFetcher() {
        // Prevent instantiation
    }

    public static String fetchFirstAvailable() throws InterruptedException, ExecutionException {

        try (var scope = new StructuredTaskScope.ShutdownOnSuccess<String>()) {

            scope.fork(() -> {
                Thread.sleep(200);
                return "Data from source A";
            });

            scope.fork(() -> {
                Thread.sleep(100);
                return "Data from source B";
            });

            scope.fork(() -> {
                Thread.sleep(300);
                return "Data from source C";
            });

            scope.join(); // Wait for first success

            return scope.result();
        }
    }

}
