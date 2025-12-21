package es.jgm1997.virtualthreads;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VirtualReservationTask implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(VirtualReservationTask.class.getName());
    private final int taskId;

    public VirtualReservationTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            LOGGER.log(Level.FINE, "Executing VirtualReservationTask {0}", taskId);
            Thread.sleep(ThreadLocalRandom.current().nextInt(50, 150));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
