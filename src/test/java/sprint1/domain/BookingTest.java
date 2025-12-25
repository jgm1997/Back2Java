package sprint1.domain;

import es.jgm1997.sprint1.domain.Booking;
import es.jgm1997.sprint1.domain.Resource;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookingTest {

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
        // Refactored to call a single helper method that may throw
        assertThrows(IllegalArgumentException.class, this::createBookingWithNullResource);

    }

    @Test
    void throwExceptionWhenEndBeforeStart() {
        var resource = new Resource(UUID.randomUUID(), "Pista 1", "PISTA", true);

        // Refactored to call a single helper method that may throw
        // The helper uses the same resource instance captured above
        assertThrows(IllegalArgumentException.class, () -> createBookingWithEndBeforeStart(resource));

    }

    // Helper methods extracted so the lambda contains a single invocation that can throw
    private void createBookingWithNullResource() {
        new Booking(
                UUID.randomUUID(),
                null,
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1),
                "javier"
        );
    }

    private void createBookingWithEndBeforeStart(Resource resource) {
        new Booking(
                UUID.randomUUID(),
                resource,
                LocalDateTime.now().plusHours(1),
                LocalDateTime.now(),
                "javier"
        );
    }
}
