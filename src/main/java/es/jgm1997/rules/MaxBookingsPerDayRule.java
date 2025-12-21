package es.jgm1997.rules;

import es.jgm1997.domain.Booking;
import es.jgm1997.domain.Resource;

public final class MaxBookingsPerDayRule implements Rule {

    public MaxBookingsPerDayRule(int maxBookingsPerDay) {
        if (maxBookingsPerDay <= 0) {
            throw new IllegalArgumentException("Maxs bookings per day must be greater than zero.");
        }
    }

    @Override
    public boolean isValid(Booking booking, Resource resource) {
        return true;
    }
}
