package es.jgm1997.rules;

import es.jgm1997.domain.Booking;
import es.jgm1997.domain.Resource;

import java.time.LocalTime;

public record FixedScheduleRule(LocalTime openingTime, LocalTime closingTime) implements Rule {

    @Override
    public boolean isValid(Booking booking, Resource resource) {
        var start = booking.start().toLocalTime();
        var end = booking.end().toLocalTime();
        return !start.isBefore(openingTime) && !end.isAfter(closingTime);
    }
}
