package com.projekt_zespolowy.tablica_ogloszen.handlers.query.image;

import com.projekt_zespolowy.tablica_ogloszen.models.image.ImageView;
import com.projekt_zespolowy.tablica_ogloszen.predicate.models.image.ImagePredicate;
import com.projekt_zespolowy.tablica_ogloszen.repositories.image.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ReadImagesHandler {

    private final ImageRepository repository;

    public List<ImageView> handle(ImagePredicate predicate) {

        List<ImageView> viewModels = this.repository.findViews(predicate.getEntityPredicate());

        return viewModels;
    }

}