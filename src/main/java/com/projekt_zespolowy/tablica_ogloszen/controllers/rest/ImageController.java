package com.projekt_zespolowy.tablica_ogloszen.controllers.rest;

import com.projekt_zespolowy.tablica_ogloszen.handlers.query.image.ReadImageDetailsHandler;
import com.projekt_zespolowy.tablica_ogloszen.models.image.ImageView;
import com.projekt_zespolowy.tablica_ogloszen.predicate.models.image.ImagePredicate;
import com.projekt_zespolowy.tablica_ogloszen.validation.DefaultSequence;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated(DefaultSequence.class)
@RestController
@RequestMapping("images")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ImageController {

    private final ReadImageDetailsHandler readDetailsHandler;

    @GetMapping(value = "/rd")
    public ResponseEntity<ImageView> readDetails(@RequestBody ImagePredicate predicate) {

        ImageView viewModel = this.readDetailsHandler.handle(predicate);

        return ResponseEntity.ok(viewModel);
    }

}
