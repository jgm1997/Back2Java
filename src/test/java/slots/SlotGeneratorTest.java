package slots;

import es.jgm1997.domain.Schedule;
import es.jgm1997.slots.SlotGenerator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SlotGeneratorTest {
    @Test
    void generateSlots() {
        var schedule = new Schedule(LocalTime.of(9, 0), LocalTime.of(10, 0), 30);
        var slots = SlotGenerator.generateSlots(LocalDate.of(2025, 1, 10), schedule);

        assertEquals(2, slots.size());
        assertEquals(LocalTime.of(9, 0), slots.getFirst().start().toLocalTime());
        assertEquals(LocalTime.of(9, 30), slots.getFirst().end().toLocalTime());
    }
}
