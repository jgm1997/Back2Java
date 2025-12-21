package es.jgm1997.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public record Booking(
        UUID id,
        Resource resource,
        LocalDateTime start,
        LocalDateTime end,
        String createdBy
) {
    public Booking {
        if (resource == null) {
            throw new IllegalArgumentException("Resource can't be null");
        }
        if (start == null || end == null) {
            throw new IllegalArgumentException("Start and end can't be null");
        }
        if (!end.isAfter(start)) {
            throw new IllegalArgumentException("End must be after start");
        }
        if (createdBy == null || createdBy.isBlank()) {
            throw new IllegalArgumentException("CreatedBy can't be null or blank");
        }
    }
}
