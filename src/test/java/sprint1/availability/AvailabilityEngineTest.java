package sprint1.availability;

import es.jgm1997.sprint1.availability.AvailabilityEngine;
import es.jgm1997.sprint1.domain.Resource;
import es.jgm1997.sprint1.domain.Schedule;
import es.jgm1997.sprint1.rules.MaxDurationRule;
import es.jgm1997.sprint1.rules.Rule;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AvailabilityEngineTest {
    @Test
    void calculatesAvailabilityCorrectly() throws Exception {

        var resource = new Resource(UUID.randomUUID(), "Court 1", "COURT", true);
        var schedule = new Schedule(LocalTime.of(9, 0), LocalTime.of(10, 0), 30);

        var rules = List.<Rule>of(
                new MaxDurationRule(60)
        );

        var result = AvailabilityEngine.calculateAvailability(
                LocalDate.of(2025, 1, 10),
                resource,
                schedule,
                rules
        );

        assertEquals(2, result.availableSlots().size());
        assertEquals(1, result.holidays().size());
    }
}
