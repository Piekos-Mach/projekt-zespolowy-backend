package com.projekt_zespolowy.tablica_ogloszen.repositories;

import com.projekt_zespolowy.tablica_ogloszen.models.offer.OfferListView;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomOfferRepository extends OrderSpecifierRepository {

    Page<OfferListView> findPage(Predicate predicate, Pageable pageable);

}
