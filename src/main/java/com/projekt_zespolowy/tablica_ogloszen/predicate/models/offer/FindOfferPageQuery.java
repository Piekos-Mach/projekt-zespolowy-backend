package com.projekt_zespolowy.tablica_ogloszen.predicate.models.offer;

import com.projekt_zespolowy.tablica_ogloszen.predicate.models.PredicatePageableQuery;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;

public class FindOfferPageQuery extends PredicatePageableQuery {

    public FindOfferPageQuery(Predicate predicate, Pageable pageable) {
        super(predicate, pageable);
    }

}
