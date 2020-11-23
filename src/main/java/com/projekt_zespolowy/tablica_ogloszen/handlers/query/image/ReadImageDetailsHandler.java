package com.projekt_zespolowy.tablica_ogloszen.handlers.query.image;

import com.projekt_zespolowy.tablica_ogloszen.models.image.ImageView;
import com.projekt_zespolowy.tablica_ogloszen.predicate.models.image.ImagePredicate;
import com.projekt_zespolowy.tablica_ogloszen.repositories.image.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ReadImageDetailsHandler {

    private final ImageRepository repository;

    public ImageView handle(ImagePredicate predicate) {

        ImageView viewModel = this.repository.findView(predicate.getId());

        return viewModel;
    }

}