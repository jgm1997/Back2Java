package es.jgm1997.availability;

import java.util.List;

import es.jgm1997.slots.Slot;

public record AvailabilityResult(
        List<Slot> availableSlots,
        List<String> appliedRules,
        List<String> reservations,
        List<String> holidays) {
}
