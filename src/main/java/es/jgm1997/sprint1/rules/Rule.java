package es.jgm1997.sprint1.rules;

import es.jgm1997.sprint1.domain.Booking;
import es.jgm1997.sprint1.domain.Resource;

public sealed interface Rule permits
        FixedScheduleRule,
        MaxBookingsPerDayRule,
        OnlyWorkingDaysRule,
        MaxDurationRule,
        CustomRule {
    boolean isValid(Booking booking, Resource resource);
}
