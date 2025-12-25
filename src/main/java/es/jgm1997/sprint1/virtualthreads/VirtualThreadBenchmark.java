package es.jgm1997.sprint1.virtualthreads;

import es.jgm1997.sprint1.concurrency.ClassicConcurrencyDemo;
import es.jgm1997.sprint1.concurrency.CompletableFutureDemo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class VirtualThreadBenchmark {
    static Logger logger = Logger.getLogger(VirtualThreadBenchmark.class.getName());

    public static void main(String[] args) throws Exception {
        int numberOfTasks = 1000;

        logger.info("Running classic fixed thread pool...");
        long classicTime = ClassicConcurrencyDemo.runWithFixedThreadPool(numberOfTasks, 50);
        logger.log(Level.INFO, "Classic time: {0} ms", classicTime);

        logger.info("Running CompletableFuture...");
        long cfTime = CompletableFutureDemo.runWithCompletableFuture(numberOfTasks);
        logger.log(Level.INFO, "CompletableFuture time: {0} ms", cfTime);

        logger.info("Running Virtual Threads...");
        long vtTime = VirtualThreadDemo.runWithVirtualThreads(numberOfTasks);
        logger.log(Level.INFO, "Virtual Threads time: {0} ms", vtTime);
    }

}
