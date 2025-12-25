package es.jgm1997.sprint1.availability;

import java.util.List;

import es.jgm1997.sprint1.slots.Slot;

public record AvailabilityResult(
        List<Slot> availableSlots,
        List<String> appliedRules,
        List<String> reservations,
        List<String> holidays) {
}
