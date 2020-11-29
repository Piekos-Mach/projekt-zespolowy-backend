package com.projekt_zespolowy.tablica_ogloszen.initialization.executors;

import com.projekt_zespolowy.tablica_ogloszen.models.image.Image;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomExecutorService {

    private static final Logger logger = Logger.getLogger(CustomExecutorService.class.getName());

    private ExecutorService executorService;
    private CountDownLatch latch;

    public CustomExecutorService(int counter) {

        this.executorService = Executors.newFixedThreadPool(counter);
        this.latch = new CountDownLatch(counter);
    }

    public Image submit(Callable<Image> callable) {

        Future<Image> futureResult = executorService.submit(callable);
        Image result = null;
        try {
            result = futureResult.get();
        } catch (InterruptedException | ExecutionException ex) {
            logger.log(Level.WARNING, ex.getMessage(), ex);
        }

        return result;
    }

    public CountDownLatch getLatch() {

        return latch;
    }

    public void await() {

        try {
            latch.await();
        } catch (InterruptedException ex) {
            logger.log(Level.WARNING, ex.getMessage(), ex);
        }
    }

    public void shutDown() {

        executorService.shutdown();
    }

}
