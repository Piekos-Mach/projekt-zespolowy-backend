package com.projekt_zespolowy.tablica_ogloszen.handlers.query.offer;

import com.projekt_zespolowy.tablica_ogloszen.mappers.OfferMapper;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.Offer;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.OfferView;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.OfferViewL;
import com.projekt_zespolowy.tablica_ogloszen.predicate.models.offer.OfferIdPredicate;
import com.projekt_zespolowy.tablica_ogloszen.repositories.offer.OfferRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ReadOfferViewHandler {

    private final OfferRepository repository;
    private final OfferMapper mapper;

    public OfferView handle(OfferIdPredicate predicate) {

        Offer entity = this.repository.findById(predicate.getId()).orElse(new Offer());
        OfferView viewModel = this.mapper.entityToView(entity);

        return viewModel;
    }

    public OfferViewL handleL(OfferIdPredicate predicate) {

        OfferViewL view = this.repository.findViewById(predicate.getId());

        return view;
    }

}