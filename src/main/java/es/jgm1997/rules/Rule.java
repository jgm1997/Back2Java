package es.jgm1997.rules;

import es.jgm1997.domain.Booking;
import es.jgm1997.domain.Resource;

public sealed interface Rule permits
        FixedScheduleRule,
        MaxBookingsPerDayRule,
        OnlyWorkingDaysRule,
        MaxDurationRule,
        CustomRule {
    boolean isValid(Booking booking, Resource resource);
}
