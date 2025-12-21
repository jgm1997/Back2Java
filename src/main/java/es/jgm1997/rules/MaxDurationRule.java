package es.jgm1997.rules;

import es.jgm1997.domain.Booking;
import es.jgm1997.domain.Resource;

import java.time.Duration;

public final class MaxDurationRule implements Rule {
    private final int maxDuration;

    public MaxDurationRule(int maxDuration) {
        if (maxDuration <= 0) {
            throw new IllegalArgumentException("Max duration must be positive.");
        }
        this.maxDuration = maxDuration;
    }

    @Override
    public boolean isValid(Booking booking, Resource resource) {
        var minutes = Duration.between(booking.start(), booking.end()).toMinutes();
        return minutes <= maxDuration;
    }

    public int getMaxDuration() {
        return maxDuration;
    }
}
