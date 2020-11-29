package com.projekt_zespolowy.tablica_ogloszen.initialization.processes;

import com.google.common.collect.Lists;
import com.projekt_zespolowy.tablica_ogloszen.initialization.executors.CustomExecutorService;
import com.projekt_zespolowy.tablica_ogloszen.initialization.executors.ImageProcessExecutor;
import com.projekt_zespolowy.tablica_ogloszen.models.image.Image;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class InitializationImagesBuilder {

    private static final Logger logger = Logger.getLogger(InitializationImagesBuilder.class.getName());

    public List<Image> run(File[] images) {

        List<Image> imagesEntities = processImages(images);
        imagesEntities.removeAll(Collections.singleton(null));

        return imagesEntities;
    }

    private List<Image> processImages(File[] images) {

        List<Image> result = Lists.newArrayList();
        try {
            int imagesAmount = images.length;
            result = Lists.newArrayListWithCapacity(imagesAmount);
            CustomExecutorService executorService = new CustomExecutorService(imagesAmount);
            for (File image : images) {
                result.add(processImage(image, executorService));
            }
            executorService.await();
            executorService.shutDown();
        } catch (Exception ex) {
            logger.log(Level.WARNING, ex.getMessage(), ex);
        }

        return result;
    }

    private Image processImage(File image, CustomExecutorService executorService) {

        Image result = null;
        try {
            ImageProcessExecutor imageProcessExecutor = new ImageProcessExecutor(image, executorService.getLatch());
            result = executorService.submit(imageProcessExecutor);
        } catch (Exception ex) {
            logger.log(Level.WARNING, ex.getMessage(), ex);
        }

        return result;
    }

}