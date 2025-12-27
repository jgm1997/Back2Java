package es.jgm1997.sprint1.availability;

import es.jgm1997.sprint1.domain.Booking;
import es.jgm1997.sprint1.domain.Resource;
import es.jgm1997.sprint1.domain.Schedule;
import es.jgm1997.sprint1.rules.Rule;
import es.jgm1997.sprint1.slots.Slot;
import es.jgm1997.sprint1.slots.SlotGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;

public class AvailabilityEngine {
    private AvailabilityEngine() {
    }

    @SuppressWarnings("preview")
    public static AvailabilityResult calculateAvailability(
            LocalDate date,
            Resource resource,
            Schedule schedule,
            List<Rule> rules) throws InterruptedException, ExecutionException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            var rulesFuture = scope.fork(() -> rules);
            var bookingsFuture = scope.fork(() -> {
                Thread.sleep(150);
                return List.<Booking>of();
            });
            var holidaysFuture = scope.fork(() -> {
                Thread.sleep(100);
                return List.of("Holiday X");
            });
            var slotsFuture = scope.fork(() -> SlotGenerator.generateSlots(date, schedule));
            scope.join();
            scope.throwIfFailed();

            List<Slot> slots = slotsFuture.get();
            List<Rule> fetchedRules = rulesFuture.get();
            List<Booking> bookings = bookingsFuture.get();
            List<String> holidays = holidaysFuture.get();
            List<Slot> availableSlots = RuleEvaluator.applyRules(slots, fetchedRules, resource, bookings);
            return new AvailabilityResult(
                    availableSlots,
                    fetchedRules.stream().map(Object::toString).toList(),
                    bookings.stream().map(Object::toString).toList(),
                    holidays);
        }
    }
}
