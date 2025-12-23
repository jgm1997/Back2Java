package domain;

import es.jgm1997.domain.Schedule;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ScheduleTest {
    @Test
    void createValidSchedule() {
        var schedule = new Schedule(LocalTime.of(9, 0), LocalTime.of(18, 0), 30);

        assertEquals(LocalTime.of(9, 0), schedule.start());
        assertEquals(LocalTime.of(18, 0), schedule.end());
        assertEquals(30, schedule.durationMinutes());
    }

    @Test
    void throwExceptionWhenEndBeforeStart() {
        // Refactored to call a single helper method that may throw
        assertThrows(IllegalArgumentException.class, this::createScheduleWithEndBeforeStart);
    }

    @Test
    void throwExceptionWhenDurationNegative() {
        // Refactored to call a single helper method that may throw
        assertThrows(IllegalArgumentException.class, this::createScheduleWithNegativeDuration);
    }

    // Helper methods extracted so the lambda contains a single invocation that can throw
    private void createScheduleWithEndBeforeStart() {
        new Schedule(LocalTime.of(18, 0), LocalTime.of(9, 0), 30);
    }

    private void createScheduleWithNegativeDuration() {
        new Schedule(LocalTime.of(18, 0), LocalTime.of(9, 0), -30);
    }
}
