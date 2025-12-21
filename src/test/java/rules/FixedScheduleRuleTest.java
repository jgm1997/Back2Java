package rules;

import es.jgm1997.domain.Booking;
import es.jgm1997.domain.Resource;
import es.jgm1997.rules.FixedScheduleRule;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FixedScheduleRuleTest {
    @Test
    void validBookingSchedule() {
        var rule = new FixedScheduleRule(LocalTime.of(9, 0), LocalTime.of(18, 0));
        var resource = new Resource(UUID.randomUUID(), "Pista 1", "PISTA", true);

        var booking = new Booking(
                UUID.randomUUID(),
                resource,
                LocalDateTime.of(2025, 1, 10, 10, 0),
                LocalDateTime.of(2025, 1, 10, 11, 0),
                "javier"
        );

        assertTrue(rule.isValid(booking, resource));
    }

    @Test
    void nonValidBookingOutOfTime() {
        var rule = new FixedScheduleRule(LocalTime.of(9, 0), LocalTime.of(18, 0));
        var resource = new Resource(UUID.randomUUID(), "Pista 1", "PISTA", true);

        var booking = new Booking(
                UUID.randomUUID(),
                resource,
                LocalDateTime.of(2025, 1, 10, 8, 0),
                LocalDateTime.of(2025, 1, 10, 9, 0),
                "javier"
        );

        assertFalse(rule.isValid(booking, resource));
    }

}
