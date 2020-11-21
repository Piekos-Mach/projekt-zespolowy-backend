package com.projekt_zespolowy.tablica_ogloszen.repositories;

import com.projekt_zespolowy.tablica_ogloszen.mappers.ImageMapper;
import com.projekt_zespolowy.tablica_ogloszen.models.basic.BasicView;
import com.projekt_zespolowy.tablica_ogloszen.models.image.Image;
import com.projekt_zespolowy.tablica_ogloszen.models.image.ImageView;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.Offer;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.OfferListView;
import com.projekt_zespolowy.tablica_ogloszen.models.price.PriceView;
import com.projekt_zespolowy.tablica_ogloszen.query_factories.ImageQueryFactory;
import com.projekt_zespolowy.tablica_ogloszen.query_factories.OfferQueryFactory;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OfferRepositoryImpl extends BasicRepository implements CustomOfferRepository {

    private final ImageMapper imageMapper;

    @Override
    public Page<OfferListView> findPage(Predicate predicate, Pageable pageable) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        JPAQuery<OfferListView> query =
                queryFactory
                        .select(
                                Projections.constructor(
                                        OfferListView.class,
                                        OfferQueryFactory.id(),
                                        Projections.constructor(
                                                BasicView.class,
                                                OfferQueryFactory.ownerId(),
                                                OfferQueryFactory.ownerName()
                                        ),
                                        OfferQueryFactory.title(),
                                        OfferQueryFactory.text(),
                                        Projections.constructor(
                                                PriceView.class,
                                                OfferQueryFactory.priceValue(),
                                                Projections.constructor(BasicView.class,
                                                        OfferQueryFactory.priceCurrencyId(),
                                                        OfferQueryFactory.priceCurrencyName()
                                                )
                                        ),
                                        // tu cos od zdjec
                                        OfferQueryFactory.creationDate()
                                ))
                        .from(OfferQueryFactory.offer())
                        .where(predicate);
        if (pageable != null) {
            query
                    .orderBy(getOrderSpecifiers(pageable, Offer.class))
                    .limit(pageable.getPageSize())
                    .offset(pageable.getPageNumber() * pageable.getPageSize());
        } else {
            query.orderBy(OfferQueryFactory.id().asc());
        }
        List<OfferListView> data = this.getOneToManyRelations(query, queryFactory);
        long count = query.fetchCount();

        return new PageImpl<>(data, pageable, count);
    }

    protected List<OfferListView> getOneToManyRelations(
            JPAQuery<OfferListView> query, JPAQueryFactory queryFactory) {

        List<OfferListView> data = query.fetch();
        for (OfferListView row : data) {
            Long offerId = row.getId();
            List<ImageView> imageViews = this.getImageViews(offerId, queryFactory);
            row.setImages(imageViews);
        }

        return data;
    }

    public List<ImageView> getImageViews(Long offerId, JPAQueryFactory queryFactory) {

        List<Image> entities = queryFactory.selectFrom(ImageQueryFactory.image()).where(ImageQueryFactory.offerId().eq(offerId)).fetch();
        List<ImageView> views = imageMapper.entitiesToViews(entities);

        return views;
    }

}
