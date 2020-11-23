package com.projekt_zespolowy.tablica_ogloszen.repositories.image;

import com.projekt_zespolowy.tablica_ogloszen.models.image.ImageView;
import com.projekt_zespolowy.tablica_ogloszen.predicate.factories.ImageQueryFactory;
import com.projekt_zespolowy.tablica_ogloszen.predicate.factories.OfferQueryFactory;
import com.projekt_zespolowy.tablica_ogloszen.repositories.BasicRepository;
import com.projekt_zespolowy.tablica_ogloszen.service.Deserializer;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class CustomRepositoryImpl
        extends BasicRepository
        implements CustomImageRepository, Deserializer {

    @Override
    public ImageView findView(Long id) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        JPAQuery<ImageView> query =
                queryFactory
                        .select(
                                Projections.constructor(
                                        ImageView.class,
                                        ImageQueryFactory.id(),
                                        ImageQueryFactory.content(),
                                        ImageQueryFactory.offerId()
                                ))
                        .from(OfferQueryFactory.offer())
                        .where(ImageQueryFactory.id().eq(id));

        return query.fetchOne();
    }

}