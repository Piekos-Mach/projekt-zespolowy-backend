package com.projekt_zespolowy.tablica_ogloszen.repositories.offer;

import com.projekt_zespolowy.tablica_ogloszen.models.offer.OfferListView;
import com.projekt_zespolowy.tablica_ogloszen.repositories.OrderSpecifierRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomOfferRepository extends OrderSpecifierRepository {

    public abstract Page<OfferListView> findPage(Predicate predicate, Pageable pageable);

}