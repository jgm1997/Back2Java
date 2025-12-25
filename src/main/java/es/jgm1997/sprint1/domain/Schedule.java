package es.jgm1997.sprint1.domain;

import java.time.LocalTime;

public record Schedule(
        LocalTime start,
        LocalTime end,
        int durationMinutes
) {
    public Schedule {
        if (start == null || end == null) {
            throw new IllegalArgumentException("start and end time can't be null");
        }
        if (!end.isAfter(start)) {
            throw new IllegalArgumentException("End time must be after start time");
        }
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("duration minutes must be positive");
        }
    }
}
