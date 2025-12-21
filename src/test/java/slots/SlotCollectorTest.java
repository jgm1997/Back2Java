package slots;

import es.jgm1997.domain.Schedule;
import es.jgm1997.slots.SlotCollector;
import es.jgm1997.slots.SlotGenerator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SlotCollectorTest {
    @Test
    void orderedGroupByHour() {
        var schedule = new Schedule(LocalTime.of(9, 0), LocalTime.of(11, 0), 30);
        var slots = SlotGenerator.generateSlots(LocalDate.of(2025, 1, 10), schedule);
        var map = slots.stream().collect(SlotCollector.orderedGroupByHour());
        var hours = map.keySet().stream().toList();

        assertEquals(LocalTime.of(9, 0), hours.get(0));
        assertEquals(LocalTime.of(9, 30), hours.get(1));
        assertEquals(LocalTime.of(10, 0), hours.get(2));
        assertEquals(LocalTime.of(10, 30), hours.get(3));
    }
}
