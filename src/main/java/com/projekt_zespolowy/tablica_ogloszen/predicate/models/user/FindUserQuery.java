package com.projekt_zespolowy.tablica_ogloszen.predicate.models.user;

import com.projekt_zespolowy.tablica_ogloszen.predicate.models.PredicateQuery;
import com.querydsl.core.types.Predicate;

import javax.validation.constraints.NotNull;

public class FindUserQuery extends PredicateQuery {

    public FindUserQuery(@NotNull Predicate predicate) {
        super(predicate);
    }

}
