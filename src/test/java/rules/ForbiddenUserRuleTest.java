package rules;

import es.jgm1997.domain.Booking;
import es.jgm1997.domain.Resource;
import es.jgm1997.rules.ForbiddenUserRule;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ForbiddenUserRuleTest {
    @Test
    void forbiddenUsernameCannotBook() {
        var rule = new ForbiddenUserRule("javier");
        var resource = new Resource(UUID.randomUUID(), "Pista", "PISTA", true);

        var booking = new Booking(
                UUID.randomUUID(),
                resource,
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1),
                "javier"
        );

        assertFalse(rule.isValid(booking, resource));
    }

    @Test
    void allowedUsernameCanBook() {
        var rule = new ForbiddenUserRule("otro");
        var resource = new Resource(UUID.randomUUID(), "Pista", "PISTA", true);

        var booking = new Booking(
                UUID.randomUUID(),
                resource,
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1),
                "javier"
        );

        assertTrue(rule.isValid(booking, resource));
    }
}
