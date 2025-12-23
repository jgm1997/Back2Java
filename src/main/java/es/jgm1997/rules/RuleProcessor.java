package es.jgm1997.rules;

public class RuleProcessor {
    private RuleProcessor() { throw new IllegalStateException("Utility class"); }

    public static String describe(Rule rule) {
        return switch (rule) {
            case FixedScheduleRule(var openingTime, var closingTime) -> "Active from " + openingTime + " to " + closingTime;
            case MaxBookingsPerDayRule(var maxBookingsPerDay) -> "Maximum of " + maxBookingsPerDay + " bookings per day";
            case OnlyWorkingDaysRule ignored -> "Only working days allowed";
            case MaxDurationRule(var maxDuration) -> "Maximum duration of " + maxDuration + " minutes";
            case ForbiddenUserRule fur -> "Forbidden user ID: " + fur.getForbiddenUsername();
            case CustomRule cr -> "Custom rule: " + cr.getRuleName();
        };
    }
}
