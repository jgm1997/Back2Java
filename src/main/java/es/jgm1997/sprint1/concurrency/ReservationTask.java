package es.jgm1997.sprint1.concurrency;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReservationTask implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(ReservationTask.class.getName());
    private final int taskId;

    public ReservationTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            LOGGER.log(Level.FINE, "Executing ReservationTask {0}", taskId);
            Thread.sleep(ThreadLocalRandom.current().nextInt(50, 150));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
