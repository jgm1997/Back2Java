package rules;

import es.jgm1997.domain.Booking;
import es.jgm1997.domain.Resource;
import es.jgm1997.rules.OnlyWorkingDaysRule;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OnlyWorkingDaysRuleTest {
    @Test
    void validWorkingDayBooking() {
        var rule = new OnlyWorkingDaysRule();
        var resource = new Resource(UUID.randomUUID(), "Pista 1", "PISTA", true);
        var booking = new Booking(
                UUID.randomUUID(),
                resource,
                LocalDateTime.of(2025, 1, 10, 10, 0), // Friday
                LocalDateTime.of(2025, 1, 10, 11, 0),
                "user1"
        );
        assertTrue(rule.isValid(booking, resource));
    }

    @Test
    void nonValidWorkingDayBooking() {
        var rule = new OnlyWorkingDaysRule();
        var resource = new Resource(UUID.randomUUID(), "Pista 1", "PISTA", true);
        var booking = new Booking(
                UUID.randomUUID(),
                resource,
                LocalDateTime.of(2025, 1, 11, 10, 0), // Saturday
                LocalDateTime.of(2025, 1, 11, 11, 0),
                "user1"
        );
        assertFalse(rule.isValid(booking, resource));
    }
}
