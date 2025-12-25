package structured;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import es.jgm1997.structured.AvailabilityCalculator;

class AvailabilityCalculatorTest {
    @Test
    void calculatesAvailabilityCorrectly() throws Exception {
        var result = AvailabilityCalculator.calculate(LocalDate.now());

        assertEquals(3, result.rules().size());
        assertEquals(2, result.reservations().size());
        assertEquals(1, result.holidays().size());
    }

}
