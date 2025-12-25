package es.jgm1997.sprint1.domain;

import java.util.UUID;

public record Resource(
        UUID id,
        String name,
        String type,
        boolean active
) {
}
