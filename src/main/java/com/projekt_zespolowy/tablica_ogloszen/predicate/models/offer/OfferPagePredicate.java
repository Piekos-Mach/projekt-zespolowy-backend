package com.projekt_zespolowy.tablica_ogloszen.predicate.models.offer;

import com.projekt_zespolowy.tablica_ogloszen.predicate.models.PagePredicate;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;

public class OfferPagePredicate extends PagePredicate {

    public OfferPagePredicate(Predicate predicate, Pageable pageable) {
        super(predicate, pageable);
    }

}
