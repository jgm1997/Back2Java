package es.jgm1997.slots;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class SlotUtils {
    private SlotUtils() { throw new IllegalStateException("Utility class"); }

    public static Map<LocalTime, List<Slot>> groupByHour(List<Slot> slots) {
        Objects.requireNonNull(slots, "slots can't be null");
        Map<LocalTime, List<Slot>> grouped = slots.stream().collect(Collectors.groupingBy(slot -> slot.start().toLocalTime()));
        return Collections.unmodifiableMap(grouped);
    }
}
