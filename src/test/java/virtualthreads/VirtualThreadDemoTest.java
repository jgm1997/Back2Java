package virtualthreads;

import es.jgm1997.virtualthreads.VirtualThreadDemo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class VirtualThreadDemoTest {

    @Test
    void runsWithoutErrors() throws Exception {
        long time = VirtualThreadDemo.runWithVirtualThreads(50);
        assertTrue(time > 0);
    }
}
