package com.projekt_zespolowy.tablica_ogloszen.handlers.query.offer;

import com.projekt_zespolowy.tablica_ogloszen.mappers.OfferMapper;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.Offer;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.OfferView;
import com.projekt_zespolowy.tablica_ogloszen.predicate.models.offer.FindOfferQuery;
import com.projekt_zespolowy.tablica_ogloszen.repositories.offer.OfferRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ReadOfferViewHandler {

    private final OfferRepository repository;
    private final OfferMapper mapper;

    public OfferView handle(FindOfferQuery query) {

        List<Offer> entities = (List<Offer>) this.repository.findAll(query.getPredicate());
        Offer entity = entities.size() == 1 ? entities.get(0) : new Offer();
        OfferView viewModel = this.mapper.entityToView(entity);

        return viewModel;
    }

}