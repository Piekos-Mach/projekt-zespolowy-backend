package com.projekt_zespolowy.tablica_ogloszen.repositories.offer;

import com.projekt_zespolowy.tablica_ogloszen.models.offer.Offer;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.QOffer;
import com.querydsl.core.types.dsl.DateTimePath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import java.time.LocalDateTime;

public interface OfferRepository extends
        JpaRepository<Offer, Long>,
        QuerydslBinderCustomizer<QOffer>,
        QuerydslPredicateExecutor<Offer>,
        CustomOfferRepository {

    @Override
    default void customize(QuerydslBindings querydslBindings, QOffer qOffer) {

        querydslBindings
                .bind(qOffer.creationDate)
                .first((DateTimePath<LocalDateTime> path, LocalDateTime creationDate) -> path.goe(creationDate));
    }

}