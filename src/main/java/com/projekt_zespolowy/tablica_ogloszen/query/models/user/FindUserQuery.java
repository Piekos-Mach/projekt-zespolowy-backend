package com.projekt_zespolowy.tablica_ogloszen.query.models.user;

import com.projekt_zespolowy.tablica_ogloszen.query.models.PredicateQuery;
import com.querydsl.core.types.Predicate;

import javax.validation.constraints.NotNull;

public class FindUserQuery extends PredicateQuery {

    public FindUserQuery(@NotNull Predicate predicate) {
        super(predicate);
    }

}
