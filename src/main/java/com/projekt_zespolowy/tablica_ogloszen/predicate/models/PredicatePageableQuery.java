package com.projekt_zespolowy.tablica_ogloszen.predicate.models;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;

public class PredicatePageableQuery extends PredicateQuery {

    private Pageable pageable;

    public PredicatePageableQuery(Predicate predicate, Pageable pageable) {
        super(predicate);
        this.pageable = pageable;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

}
