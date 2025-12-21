package concurrency;

import es.jgm1997.concurrency.ClassicConcurrencyDemo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ClassicConcurrencyDemoTest {

    @Test
    void runsWithoutErrors() throws Exception {
        long time = ClassicConcurrencyDemo.runWithFixedThreadPool(50, 10);
        assertTrue(time > 0);
    }
}
