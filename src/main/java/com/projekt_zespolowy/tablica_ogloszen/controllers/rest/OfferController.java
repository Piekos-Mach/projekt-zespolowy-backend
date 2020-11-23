package com.projekt_zespolowy.tablica_ogloszen.controllers.rest;

import com.projekt_zespolowy.tablica_ogloszen.handlers.command.offer.CreateOfferHandler;
import com.projekt_zespolowy.tablica_ogloszen.handlers.command.offer.DeleteOfferHandler;
import com.projekt_zespolowy.tablica_ogloszen.handlers.command.offer.UpdateOfferHandler;
import com.projekt_zespolowy.tablica_ogloszen.handlers.query.offer.BuildCreateOfferFormHandler;
import com.projekt_zespolowy.tablica_ogloszen.handlers.query.offer.BuildUpdateOfferFormHandler;
import com.projekt_zespolowy.tablica_ogloszen.handlers.query.offer.ReadOfferPageHandler;
import com.projekt_zespolowy.tablica_ogloszen.handlers.query.offer.ReadOfferViewHandler;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.*;
import com.projekt_zespolowy.tablica_ogloszen.predicate.models.offer.FindOfferPageQuery;
import com.projekt_zespolowy.tablica_ogloszen.predicate.models.offer.FindOfferQuery;
import com.projekt_zespolowy.tablica_ogloszen.validation.DefaultSequence;
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

@Validated(DefaultSequence.class)
@RestController
@RequestMapping("offers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OfferController {

    private final CreateOfferHandler createHandler;
    private final UpdateOfferHandler updateHandler;
    private final DeleteOfferHandler deleteHandler;
    private final ReadOfferViewHandler readDetailsHandler;
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

    @GetMapping(value = "/rd")
    public ResponseEntity<OfferView> readDetails(@QuerydslPredicate(root = Offer.class) Predicate predicate) {

        OfferView viewModel = this.readDetailsHandler.handle(new FindOfferQuery(predicate));

        return ResponseEntity.ok(viewModel);
    }

    @GetMapping(value = "/buf")
    public ResponseEntity<UpdateOfferForm> buildUpdateForm(@QuerydslPredicate(root = Offer.class) Predicate predicate) {

        UpdateOfferForm form = this.buildUpdateFormHandler.handle(new FindOfferQuery(predicate));

        return ResponseEntity.ok(form);
    }

    @GetMapping(value = "/bcf")
    public ResponseEntity<CreateOfferForm> buildCreateForm() {

        CreateOfferForm form = this.buildCreateFormHandler.handle();

        return ResponseEntity.ok(form);
    }

    @GetMapping(value = "/rp")
    public ResponseEntity<Page<OfferPageView>> readPage(
            @QuerydslPredicate(root = Offer.class) Predicate predicate,
            @PageableDefault(sort = {"id"}, value = 20) Pageable pageable) {

        FindOfferPageQuery query = new FindOfferPageQuery(predicate, pageable);
        Page<OfferPageView> pageView = this.readOfferPageHandler.handle(query);

        return ResponseEntity.ok(pageView);
    }

}