package es.jgm1997.sprint1.slots;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collector;

public class SlotCollector {
    private SlotCollector() { throw new IllegalStateException("Utility class"); }

    public static Collector<Slot, ?, Map<LocalTime, List<Slot>>> orderedGroupByHour() {
        return Collector.of(
                TreeMap::new,
                (map, slot) -> map
                        .computeIfAbsent(slot.start().toLocalTime(), k -> new ArrayList<>())
                        .add(slot),
                (map1, map2) -> {
                    map2.forEach((hour, slotList) ->
                            map1.merge(hour, slotList, (list1, list2) -> {
                                var merged = new ArrayList<>(list1);
                                merged.addAll(list2);
                                return merged;
                            })
                    );
                    return map1;
                }
        );
    }
}
