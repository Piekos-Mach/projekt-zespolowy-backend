package com.projekt_zespolowy.tablica_ogloszen.repositories;

import com.projekt_zespolowy.tablica_ogloszen.query.models.SortingOrder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.EntityPathBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomQueryDslRepositoryExtension<T, Q extends EntityPathBase<T>> {

    public abstract Page<T> findAll(Q qClass, Predicate predicate, Pageable pageable, SortingOrder sortingOrder);

}
