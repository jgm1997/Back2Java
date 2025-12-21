package es.jgm1997.rules;

import es.jgm1997.domain.Booking;
import es.jgm1997.domain.Resource;

import java.time.DayOfWeek;

public final class OnlyWorkingDaysRule implements Rule {
    @Override
    public boolean isValid(Booking booking, Resource resource) {
        var day = booking.start().getDayOfWeek();
        return day != DayOfWeek.SATURDAY && day != DayOfWeek.SUNDAY;
    }
}
