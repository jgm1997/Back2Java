package es.jgm1997.sprint1.availability;

import es.jgm1997.sprint1.domain.Booking;
import es.jgm1997.sprint1.domain.Resource;
import es.jgm1997.sprint1.rules.Rule;
import es.jgm1997.sprint1.slots.Slot;

import java.util.List;
import java.util.stream.Collectors;

public class RuleEvaluator {
    public static List<Slot> applyRules(
            List<Slot> slots,
            List<Rule> rules,
            Resource resource,
            List<Booking> bookings
    ) {
        return slots.stream().filter(slot ->
                rules.stream().allMatch(rule ->
                        rule.isValid(new Booking(
                                null, resource, slot.start(), slot.end(), "system"
                        ), resource)
                )
        ).collect(Collectors.toList());
    }
}
