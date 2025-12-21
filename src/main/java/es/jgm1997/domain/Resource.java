package es.jgm1997.domain;

import java.util.UUID;

public record Resource(
        UUID id,
        String name,
        String type,
        boolean active
) {
}
