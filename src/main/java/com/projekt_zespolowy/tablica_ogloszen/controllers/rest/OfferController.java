package com.projekt_zespolowy.tablica_ogloszen.controllers.rest;

import com.projekt_zespolowy.tablica_ogloszen.handlers.command.offer.CreateOfferHandler;
import com.projekt_zespolowy.tablica_ogloszen.handlers.command.offer.DeleteOfferHandler;
import com.projekt_zespolowy.tablica_ogloszen.handlers.command.offer.UpdateOfferHandler;
import com.projekt_zespolowy.tablica_ogloszen.handlers.query.offer.BuildCreateOfferFormHandler;
import com.projekt_zespolowy.tablica_ogloszen.handlers.query.offer.BuildUpdateOfferFormHandler;
import com.projekt_zespolowy.tablica_ogloszen.handlers.query.offer.ReadOfferPageHandler;
import com.projekt_zespolowy.tablica_ogloszen.handlers.query.offer.ReadOfferViewHandler;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.*;
import com.projekt_zespolowy.tablica_ogloszen.predicate.models.offer.OfferPagePredicate;
import com.projekt_zespolowy.tablica_ogloszen.predicate.models.offer.OfferIdPredicate;
import com.projekt_zespolowy.tablica_ogloszen.validation.DefaultSequence;
import com.projekt_zespolowy.tablica_ogloszen.validation.FirstLevel;
import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Validated(DefaultSequence.class)
@RestController
@RequestMapping("offers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OfferController {

    private final CreateOfferHandler createHandler;
    private final UpdateOfferHandler updateHandler;
    private final DeleteOfferHandler deleteHandler;
    private final ReadOfferViewHandler readViewHandler;
    private final BuildUpdateOfferFormHandler buildUpdateFormHandler;
    private final BuildCreateOfferFormHandler buildCreateFormHandler;
    private final ReadOfferPageHandler readOfferPageHandler;

    @PostMapping
    public ResponseEntity<OfferView> create(@Validated(DefaultSequence.class) @RequestBody CreateOfferCmd cmd) {

        OfferView viewModel = this.createHandler.handle(cmd);

        return ResponseEntity.ok(viewModel);
    }

    @PutMapping
    public ResponseEntity<OfferView> update(@Validated(DefaultSequence.class) @RequestBody UpdateOfferCmd cmd) {

        OfferView viewModel = this.updateHandler.handle(cmd);

        return ResponseEntity.ok(viewModel);
    }

    @PostMapping(value = "/d")
    public ResponseEntity delete(@Validated(DefaultSequence.class) @RequestBody DeleteOfferCmd cmd) {

        this.deleteHandler.handle(cmd);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/rv")
    public ResponseEntity<OfferView> readView(@Validated(DefaultSequence.class) @RequestBody OfferIdPredicate predicate) {

        OfferView viewModel = this.readViewHandler.handle(predicate);

        return ResponseEntity.ok(viewModel);
    }

    @GetMapping(value = "/buf")
    public ResponseEntity<UpdateOfferForm> buildUpdateForm(@Validated(DefaultSequence.class) @RequestBody OfferIdPredicate predicate) {

        UpdateOfferForm form = this.buildUpdateFormHandler.handle(predicate);

        return ResponseEntity.ok(form);
    }

    @GetMapping(value = "/bcf")
    public ResponseEntity<CreateOfferForm> buildCreateForm() {

        CreateOfferForm form = this.buildCreateFormHandler.handle();

        return ResponseEntity.ok(form);
    }

    @GetMapping(value = "/rpv")
    public ResponseEntity<Page<OfferPageView>> readPageView(
            @Validated(DefaultSequence.class)
            @NotNull(message = "predicate.notNull", groups = FirstLevel.class)
            @QuerydslPredicate(root = Offer.class) Predicate predicate,
            @PageableDefault(sort = {"id"}, value = 5) Pageable pageable) {

        OfferPagePredicate pagePredicate = new OfferPagePredicate(predicate, pageable);
        Page<OfferPageView> pageView = this.readOfferPageHandler.handle(pagePredicate);

        return ResponseEntity.ok(pageView);
    }

}