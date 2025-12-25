package sprint1.slots;

import es.jgm1997.sprint1.domain.Schedule;
import es.jgm1997.sprint1.slots.SlotGenerator;
import es.jgm1997.sprint1.slots.SlotUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SlotUtilsTest {
    @Test
    void groupByHour() {
        var schedule = new Schedule(LocalTime.of(9, 0), LocalTime.of(10, 0), 30);
        var slots = SlotGenerator.generateSlots(LocalDate.of(2025, 1, 10), schedule);
        var groupedSlots = SlotUtils.groupByHour(slots);

        assertEquals(2, groupedSlots.size());
        assertTrue(groupedSlots.containsKey(LocalTime.of(9, 0)));
        assertTrue(groupedSlots.containsKey(LocalTime.of(9, 30)));
    }
}
