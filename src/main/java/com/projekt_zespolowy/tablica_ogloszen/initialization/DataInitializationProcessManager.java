package com.projekt_zespolowy.tablica_ogloszen.initialization;

import com.projekt_zespolowy.tablica_ogloszen.initialization.processes.InitializationImagesReader;
import com.projekt_zespolowy.tablica_ogloszen.initialization.processes.InitializationImagesResolver;
import com.projekt_zespolowy.tablica_ogloszen.models.image.Image;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DataInitializationProcessManager {

    private final InitializationImagesReader initializationImagesReader;
    private final com.projekt_zespolowy.tablica_ogloszen.initialization.processes.InitializationImagesBuilder InitializationImagesBuilder;
    private final InitializationImagesResolver initializationImagesResolver;

    @PostConstruct
    public void process() {

        File[] images = this.initializationImagesReader.run();
        List<Image> imagesEntities = InitializationImagesBuilder.run(images);
        initializationImagesResolver.run(imagesEntities);
    }

}
