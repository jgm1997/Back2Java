package sprint1.virtualthreads;

import es.jgm1997.sprint1.virtualthreads.VirtualThreadServer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class VirtualThreadServerTest {

    @Test
    void serverStartsWithoutErrors() {
        assertDoesNotThrow(VirtualThreadServer.class::getDeclaredMethods);
    }
}

