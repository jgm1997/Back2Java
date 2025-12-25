package es.jgm1997.sprint1.rules;

import es.jgm1997.sprint1.domain.Booking;
import es.jgm1997.sprint1.domain.Resource;

import java.time.Duration;

public record MaxDurationRule(int maxDuration) implements Rule {

    public MaxDurationRule {
        if (maxDuration <= 0) {
            throw new IllegalArgumentException("Max duration must be positive.");
        }
    }

    @Override
    public boolean isValid(Booking booking, Resource resource) {
        var minutes = Duration.between(booking.start(), booking.end()).toMinutes();
        return minutes <= maxDuration;
    }
}
