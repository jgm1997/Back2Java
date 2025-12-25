package es.jgm1997.sprint1.concurrency;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConcurrencyBenchmark {
    public static void main(String[] args) throws Exception {
        Logger logger = Logger.getLogger(ConcurrencyBenchmark.class.getName());
        int numberOfTasks = 1000;

        logger.info("Running classic fixed thread pool...");
        long classicTime = ClassicConcurrencyDemo.runWithFixedThreadPool(numberOfTasks, 50);
        logger.log(Level.INFO, "Classic fixed thread pool time: {0} ms", classicTime);

        logger.info("Running CompletableFuture...");
        long completableFutureTime = CompletableFutureDemo.runWithCompletableFuture(numberOfTasks);
        logger.log(Level.INFO, "CompletableFuture time: {0} ms", completableFutureTime);
    }
}
