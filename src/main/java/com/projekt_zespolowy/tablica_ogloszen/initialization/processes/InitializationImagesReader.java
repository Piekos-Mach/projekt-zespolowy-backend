package com.projekt_zespolowy.tablica_ogloszen.initialization.processes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;


@Service
public class InitializationImagesReader {

    private static final Logger logger = Logger.getLogger(InitializationImagesReader.class.getName());

    @Value("${initialization.images.path}")
    private String imagesDirectory;

    public File[] run() {

        File[] images = new File[]{};
        try {
            File imagesFolder = new File(this.imagesDirectory);
            images = imagesFolder.listFiles();
        } catch (Exception ex) {
            logger.log(Level.WARNING, ex.getMessage(), ex);
        }
        return images;
    }

}