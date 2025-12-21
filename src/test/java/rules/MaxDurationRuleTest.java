package rules;

import es.jgm1997.domain.Booking;
import es.jgm1997.domain.Resource;
import es.jgm1997.rules.MaxDurationRule;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaxDurationRuleTest {
    @Test
    void validBookingWithinMaxDuration() {
        var rule = new MaxDurationRule(60);
        var resource = new Resource(UUID.randomUUID(), "Pista", "PISTA", true);

        var booking = new Booking(
                UUID.randomUUID(),
                resource,
                LocalDateTime.of(2025, 1, 10, 10, 0),
                LocalDateTime.of(2025, 1, 10, 10, 30),
                "javier"
        );

        assertTrue(rule.isValid(booking, resource));
    }

    @Test
    void maxDurationSurpassedInvalidBooking() {
        var rule = new MaxDurationRule(30);
        var resource = new Resource(UUID.randomUUID(), "Pista", "PISTA", true);

        var booking = new Booking(
                UUID.randomUUID(),
                resource,
                LocalDateTime.of(2025, 1, 10, 10, 0),
                LocalDateTime.of(2025, 1, 10, 11, 0),
                "javier"
        );

        assertFalse(rule.isValid(booking, resource));
    }

}
