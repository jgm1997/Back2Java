package es.jgm1997.structured;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;

public class AvailabilityCalculator {
    public record AvailabilityResult(
            List<String> rules,
            List<String> reservations,
            List<String> holidays) {
    }

    public static AvailabilityResult calculate(LocalDate date) throws InterruptedException, ExecutionException {

        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {

            var rulesFuture = scope.fork(() -> {
                Thread.sleep(150);
                return List.of("Rule A", "Rule B", "Rule C");
            });

            var reservationsFuture = scope.fork(() -> {
                Thread.sleep(200);
                return List.of("Reservation 1", "Reservation 2");
            });

            var holidaysFuture = scope.fork(() -> {
                Thread.sleep(100);
                return List.of("Holiday X");
            });

            scope.join();
            scope.throwIfFailed();

            return new AvailabilityResult(
                    rulesFuture.get(),
                    reservationsFuture.get(),
                    holidaysFuture.get());
        }
    }

}
