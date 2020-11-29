package com.projekt_zespolowy.tablica_ogloszen.initialization.executors;

import com.projekt_zespolowy.tablica_ogloszen.models.image.Image;
import com.projekt_zespolowy.tablica_ogloszen.service.Serializer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

@Data
@AllArgsConstructor
public class ImageProcessExecutor implements Callable<Image>, Serializer {

    private static final Logger logger = Logger.getLogger(ImageProcessExecutor.class.getName());

    private File image;
    private CountDownLatch latch;

    @Override
    public Image call() {

        try (FileInputStream imageStream = new FileInputStream(image)) {
            byte[] bytesOfImage = imageStream.readAllBytes();
            String encodeBase64 = Base64.getEncoder().encodeToString(bytesOfImage);
            String extension = image.getName();
            String imageContent64 = "data:image/" + extension + ";base64," + encodeBase64;
            byte[] imageContent = serialize(imageContent64);

            latch.countDown();
            return new Image(null, imageContent, null);
        } catch (Exception ex) {
            logger.log(Level.WARNING, ex.getMessage(), ex);
        }
        latch.countDown();
        return null;
    }

}
