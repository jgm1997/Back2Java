package rules;

import es.jgm1997.rules.FixedScheduleRule;
import es.jgm1997.rules.ForbiddenUserRule;
import es.jgm1997.rules.MaxDurationRule;
import es.jgm1997.rules.RuleProcessor;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RuleProcessorTest {
    @Test
    void correctDescriptionForEveryRule() {
        assertTrue(RuleProcessor.describe(
                new FixedScheduleRule(LocalTime.of(9, 0), LocalTime.of(18, 0))
        ).contains("Active from"));

        assertTrue(RuleProcessor.describe(
                new MaxDurationRule(60)
        ).contains("Maximum duration"));

        assertTrue(RuleProcessor.describe(
                new ForbiddenUserRule("javier")
        ).contains("Forbidden user"));
    }

}
