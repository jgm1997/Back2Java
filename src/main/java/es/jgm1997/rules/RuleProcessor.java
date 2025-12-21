package es.jgm1997.rules;

public class RuleProcessor {
    public static String describe(Rule rule) {
        return switch (rule) {
            case FixedScheduleRule fsr -> "Active from " + fsr.openingTime() + " to " + fsr.closingTime();
            case MaxBookingsPerDayRule mbpdr -> "Maximum of " + mbpdr.maxBookingsPerDay() + " bookings per day";
            case OnlyWorkingDaysRule ignored -> "Only working days allowed";
            case MaxDurationRule mdr -> "Maximum duration of " + mdr.getMaxDuration() + " minutes";
            case ForbiddenUserRule fur -> "Forbidden user ID: " + fur.getForbiddenUsername();
            case CustomRule cr -> "Custom rule: " + cr.getRuleName();
        };
    }
}
