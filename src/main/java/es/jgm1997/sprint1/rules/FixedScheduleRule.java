package es.jgm1997.sprint1.rules;

import es.jgm1997.sprint1.domain.Booking;
import es.jgm1997.sprint1.domain.Resource;

import java.time.LocalTime;

public record FixedScheduleRule(LocalTime openingTime, LocalTime closingTime) implements Rule {

    @Override
    public boolean isValid(Booking booking, Resource resource) {
        var start = booking.start().toLocalTime();
        var end = booking.end().toLocalTime();
        return !start.isBefore(openingTime) && !end.isAfter(closingTime);
    }
}
