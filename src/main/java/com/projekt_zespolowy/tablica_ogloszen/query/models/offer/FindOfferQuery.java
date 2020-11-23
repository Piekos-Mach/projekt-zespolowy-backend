package com.projekt_zespolowy.tablica_ogloszen.query.models.offer;

import com.projekt_zespolowy.tablica_ogloszen.query.models.PredicateQuery;
import com.querydsl.core.types.Predicate;

import javax.validation.constraints.NotNull;

public class FindOfferQuery extends PredicateQuery {

    public FindOfferQuery(@NotNull Predicate predicate) {
        super(predicate);
    }

}
