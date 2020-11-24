package com.projekt_zespolowy.tablica_ogloszen.repositories.image;

import com.projekt_zespolowy.tablica_ogloszen.models.image.ImageView;
import com.projekt_zespolowy.tablica_ogloszen.models.image.QImage;
import com.projekt_zespolowy.tablica_ogloszen.predicate.factories.QImageFactory;
import com.projekt_zespolowy.tablica_ogloszen.predicate.factories.QOfferFactory;
import com.projekt_zespolowy.tablica_ogloszen.repositories.BasicRepository;
import com.projekt_zespolowy.tablica_ogloszen.service.Deserializer;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

public class CustomImageRepositoryImpl
        extends BasicRepository
        implements CustomImageRepository, Deserializer {

    @Override
    public ImageView findView(Long id) {

        Predicate predicate = QImageFactory.id().eq(id);
        JPAQuery<ImageView> query = buildFindViewQuery(predicate);

        return query.fetchOne();
    }

    @Override
    public List<ImageView> findViews(Predicate predicate) {

        JPAQuery<ImageView> query = buildFindViewQuery(predicate);

        return query.fetch();
    }

    private JPAQuery<ImageView> buildFindViewQuery(Predicate predicate){

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        JPAQuery<ImageView> query =
                queryFactory
                        .select(
                                Projections.constructor(
                                        ImageView.class,
                                        QImageFactory.id(),
                                        QImageFactory.content(),
                                        QImageFactory.offerId()
                                ))
                        .from(QOfferFactory.offer())
                        .where(predicate);

        return query;
    }

}