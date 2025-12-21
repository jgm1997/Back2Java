package es.jgm1997.rules;

import es.jgm1997.domain.Booking;
import es.jgm1997.domain.Resource;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public class RuleDemo {
    public static void main(String[] args) {
        var resource = new Resource(UUID.randomUUID(), "Demo resource 1", "DEMO RESOURCE", true);
        var booking = new Booking(
                UUID.randomUUID(),
                resource,
                LocalDateTime.of(2025, 1, 10, 10, 0),
                LocalDateTime.of(2025, 1, 10, 11, 0),
                "Javier González Martín"
        );
        List<Rule> rules = List.of(
                new FixedScheduleRule(LocalTime.of(9, 0), LocalTime.of(18, 0)),
                new MaxBookingsPerDayRule(5),
                new OnlyWorkingDaysRule()
        );

        for (Rule rule : rules) {
            boolean valid = rule.isValid(booking, resource);
            System.out.println("Is booking valid? " + valid);
            System.out.println("-----");
        }
    }
}
