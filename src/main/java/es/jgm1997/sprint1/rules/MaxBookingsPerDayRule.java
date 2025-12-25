package es.jgm1997.sprint1.rules;

import es.jgm1997.sprint1.domain.Booking;
import es.jgm1997.sprint1.domain.Resource;

public record MaxBookingsPerDayRule(int maxBookingsPerDay) implements Rule {
    public MaxBookingsPerDayRule {
        if (maxBookingsPerDay <= 0) {
            throw new IllegalArgumentException("Maxs bookings per day must be greater than zero.");
        }
    }

    @Override
    public boolean isValid(Booking booking, Resource resource) {
        throw new UnsupportedOperationException("MaxBookingsPerDayRule.isValid not implemented: requires access to bookings repository to count bookings per day");
    }
}
