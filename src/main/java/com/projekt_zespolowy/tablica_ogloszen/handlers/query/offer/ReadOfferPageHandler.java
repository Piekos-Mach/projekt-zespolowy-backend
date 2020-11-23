package com.projekt_zespolowy.tablica_ogloszen.handlers.query.offer;

import com.projekt_zespolowy.tablica_ogloszen.models.offer.OfferPageView;
import com.projekt_zespolowy.tablica_ogloszen.query.models.offer.FindOfferPageQuery;
import com.projekt_zespolowy.tablica_ogloszen.repositories.offer.OfferRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ReadOfferPageHandler {

    private final OfferRepository repository;

    public Page<OfferPageView> handle(FindOfferPageQuery query) {

        Page<OfferPageView> pageView = this.repository.findPage(query.getPredicate(), query.getPageable());

        return pageView;
    }

}
