package sprint1.structured;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import es.jgm1997.sprint1.structured.StructuredConcurrencyDemo;

class StructuredConcurrencyDemoTest {
    @Test
    void runsAndReturnsCorrectSum() throws Exception {
        int result = StructuredConcurrencyDemo.runTasks();
        assertEquals(30, result);
    }

}
