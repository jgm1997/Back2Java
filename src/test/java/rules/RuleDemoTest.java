package rules;

import es.jgm1997.rules.FixedScheduleRule;
import es.jgm1997.rules.MaxBookingsPerDayRule;
import es.jgm1997.rules.OnlyWorkingDaysRule;
import es.jgm1997.rules.Rule;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RuleDemoTest {
    @Test
    void matchingSwitchPatternRuleDescription() {
        var rule1 = new FixedScheduleRule(LocalTime.of(9, 0), LocalTime.of(18, 0));
        var rule2 = new MaxBookingsPerDayRule(5);
        var rule3 = new OnlyWorkingDaysRule();

        assertTrue(describe(rule1).contains("fixed schedule"));
        assertTrue(describe(rule2).contains("max days"));
        assertTrue(describe(rule3).contains("working days"));
    }

    private String describe(Rule rule) {
        return switch (rule) {
            case FixedScheduleRule ignored -> "fixed schedule rule";
            case MaxBookingsPerDayRule ignored -> "max days rule";
            case OnlyWorkingDaysRule ignored -> "working days rule";
        };
    }
}
