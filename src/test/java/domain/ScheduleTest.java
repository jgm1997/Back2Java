package domain;

import es.jgm1997.domain.Schedule;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScheduleTest {
    @Test
    void createValidSchedule() {
        var schedule = new Schedule(LocalTime.of(9, 0), LocalTime.of(18, 0), 30);

        assertEquals(LocalTime.of(9, 0), schedule.start());
        assertEquals(LocalTime.of(18, 0), schedule.end());
        assertEquals(30, schedule.durationMinutes());
    }

    @Test
    void throwExceptionWhenEndBeforeStart() {
        assertThrows(IllegalArgumentException.class, () ->
                new Schedule(LocalTime.of(18, 0), LocalTime.of(9, 0), 30)
        );
    }

    @Test
    void throwExceptionWhenDurationNegative() {
        assertThrows(IllegalArgumentException.class, () ->
                new Schedule(LocalTime.of(18, 0), LocalTime.of(9, 0), -30)
        );
    }
}
