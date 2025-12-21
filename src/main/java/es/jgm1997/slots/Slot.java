package es.jgm1997.slots;

import java.time.LocalDateTime;

public record Slot(LocalDateTime start, LocalDateTime end) {
    public Slot {
        if (!end.isAfter(start)) {
            throw new IllegalArgumentException("Slot end time must be after start time");
        }
    }
}
