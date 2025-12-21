package domain;

import es.jgm1997.domain.Booking;
import es.jgm1997.domain.Resource;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookingTest {

    @Test
    void createValidBooking() {
        var resource = new Resource(UUID.randomUUID(), "Pista 1", "PISTA", true);

        var booking = new Booking(
                UUID.randomUUID(),
                resource,
                LocalDateTime.of(2025, 1, 10, 10, 0),
                LocalDateTime.of(2025, 1, 10, 11, 0),
                "javier"
        );

        assertEquals("javier", booking.createdBy());
        assertEquals(resource, booking.resource());

    }

    @Test
    void throwExceptionWhenNullResource() {
        assertThrows(IllegalArgumentException.class, () ->
                new Booking(
                        UUID.randomUUID(),
                        null,
                        LocalDateTime.now(),
                        LocalDateTime.now().plusHours(1),
                        "javier"
                )
        );

    }

    @Test
    void throwExceptionWhenEndBeforeStart() {
        var resource = new Resource(UUID.randomUUID(), "Pista 1", "PISTA", true);

        assertThrows(IllegalArgumentException.class, () ->
                new Booking(
                        UUID.randomUUID(),
                        resource,
                        LocalDateTime.now().plusHours(1),
                        LocalDateTime.now(),
                        "javier"
                )
        );

    }
}
