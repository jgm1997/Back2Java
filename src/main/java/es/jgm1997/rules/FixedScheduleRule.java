package es.jgm1997.rules;

import es.jgm1997.domain.Booking;
import es.jgm1997.domain.Resource;

import java.time.LocalTime;

public final class FixedScheduleRule implements Rule {
    private final LocalTime openingTime;
    private final LocalTime closingTime;

    public FixedScheduleRule(LocalTime openingTime, LocalTime closingTime) {
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    @Override
    public boolean isValid(Booking booking, Resource resource) {
        var start = booking.start().toLocalTime();
        var end = booking.end().toLocalTime();
        return !start.isBefore(openingTime) && !end.isAfter(closingTime);
    }
}
