package concurrency;

import es.jgm1997.concurrency.CompletableFutureDemo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CompletableFutureDemoTest {

    @Test
    void runsWithoutErrors() {
        long time = CompletableFutureDemo.runWithCompletableFuture(50);
        assertTrue(time > 0);
    }
}
