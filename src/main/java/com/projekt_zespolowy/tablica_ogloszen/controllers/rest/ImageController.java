package com.projekt_zespolowy.tablica_ogloszen.controllers.rest;

import com.projekt_zespolowy.tablica_ogloszen.handlers.query.image.ReadImageDetailsHandler;
import com.projekt_zespolowy.tablica_ogloszen.handlers.query.image.ReadImagesHandler;
import com.projekt_zespolowy.tablica_ogloszen.models.image.Image;
import com.projekt_zespolowy.tablica_ogloszen.models.image.ImageView;
import com.projekt_zespolowy.tablica_ogloszen.predicate.models.image.ImageIdPredicate;
import com.projekt_zespolowy.tablica_ogloszen.predicate.models.image.ImagePredicate;
import com.projekt_zespolowy.tablica_ogloszen.validation.DefaultSequence;
import com.projekt_zespolowy.tablica_ogloszen.validation.FirstLevel;
import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@Validated(DefaultSequence.class)
@RestController
@RequestMapping("images")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ImageController {

    private final ReadImageDetailsHandler readDetailsHandler;
    private final ReadImagesHandler readImagesHandler;

    @GetMapping(value = "/rv")
    public ResponseEntity<ImageView> readView(@Validated(DefaultSequence.class) ImageIdPredicate predicate) {

        ImageView viewModel = this.readDetailsHandler.handle(predicate);

        return ResponseEntity.ok(viewModel);
    }

    @GetMapping(value = "/rlv")
    public ResponseEntity<List<ImageView>> readListView(
            @Validated(DefaultSequence.class)
            @NotNull(message = "predicate.notNull", groups = FirstLevel.class)
            @QuerydslPredicate(root = Image.class)
                    Predicate predicate) {

        ImagePredicate imagePredicate = new ImagePredicate(predicate);
        List<ImageView> viewModels = this.readImagesHandler.handle(imagePredicate);

        return ResponseEntity.ok(viewModels);
    }

}
