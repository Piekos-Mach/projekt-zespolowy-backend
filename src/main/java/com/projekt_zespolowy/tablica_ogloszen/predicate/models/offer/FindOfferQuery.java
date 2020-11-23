package com.projekt_zespolowy.tablica_ogloszen.predicate.models.offer;

import com.projekt_zespolowy.tablica_ogloszen.predicate.models.PredicateQuery;
import com.querydsl.core.types.Predicate;

import javax.validation.constraints.NotNull;

public class FindOfferQuery extends PredicateQuery {

    public FindOfferQuery(@NotNull Predicate predicate) {
        super(predicate);
    }

}
