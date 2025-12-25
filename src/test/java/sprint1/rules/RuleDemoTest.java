package sprint1.rules;

import es.jgm1997.sprint1.rules.FixedScheduleRule;
import es.jgm1997.sprint1.rules.MaxBookingsPerDayRule;
import es.jgm1997.sprint1.rules.OnlyWorkingDaysRule;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static es.jgm1997.sprint1.rules.RuleProcessor.describe;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RuleDemoTest {
    @Test
    void matchingSwitchPatternRuleDescription() {
        var rule1 = new FixedScheduleRule(LocalTime.of(9, 0), LocalTime.of(18, 0));
        var rule2 = new MaxBookingsPerDayRule(5);
        var rule3 = new OnlyWorkingDaysRule();

        assertTrue(describe(rule1).contains("Active from"));
        assertTrue(describe(rule2).contains("bookings per day"));
        assertTrue(describe(rule3).contains("working days"));
    }

}
