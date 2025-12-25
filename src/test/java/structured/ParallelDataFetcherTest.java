package structured;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import es.jgm1997.structured.ParallelDataFetcher;

class ParallelDataFetcherTest {
    @Test
    void returnsFirstAvailableResult() throws Exception {
        String result = ParallelDataFetcher.fetchFirstAvailable();
        assertEquals("Data from source B", result);
    }

}
