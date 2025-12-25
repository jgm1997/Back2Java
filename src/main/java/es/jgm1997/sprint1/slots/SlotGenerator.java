package es.jgm1997.sprint1.slots;

import es.jgm1997.sprint1.domain.Schedule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SlotGenerator {
    private SlotGenerator() { throw new IllegalStateException("Utility class"); }

    public static List<Slot> generateSlots(LocalDate date, Schedule schedule) {
        var start = LocalDateTime.of(date, schedule.start());
        var end = LocalDateTime.of(date, schedule.end());
        var duration = schedule.durationMinutes();
        List<Slot> slots = new ArrayList<>();
        var currentStart = start;

        while (!currentStart.plusMinutes(duration).isAfter(end)) {
            var next = currentStart.plusMinutes(duration);
            slots.add(new Slot(currentStart, next));
            currentStart = next;
        }
        return slots;
    }
}
