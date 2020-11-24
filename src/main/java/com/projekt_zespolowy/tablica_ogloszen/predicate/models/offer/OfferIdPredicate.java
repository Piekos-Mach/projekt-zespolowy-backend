package com.projekt_zespolowy.tablica_ogloszen.predicate.models.offer;

import com.projekt_zespolowy.tablica_ogloszen.predicate.factories.QOfferFactory;
import com.projekt_zespolowy.tablica_ogloszen.predicate.models.IdPredicate;
import com.querydsl.core.types.Predicate;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OfferIdPredicate extends IdPredicate {

    public OfferIdPredicate(Long id) {
        super(id);
    }

    @Override
    public Predicate getIdPredicate() {

        return QOfferFactory.id().eq(super.getId());
    }

}