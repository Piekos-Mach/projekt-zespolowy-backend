package com.projekt_zespolowy.tablica_ogloszen.repositories.offer;

import com.projekt_zespolowy.tablica_ogloszen.mappers.Mapper;
import com.projekt_zespolowy.tablica_ogloszen.models.basic.BasicView;
import com.projekt_zespolowy.tablica_ogloszen.models.image.Image;
import com.projekt_zespolowy.tablica_ogloszen.models.image.ImageView;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.Offer;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.OfferPageView;
import com.projekt_zespolowy.tablica_ogloszen.models.price.PriceView;
import com.projekt_zespolowy.tablica_ogloszen.predicate.factories.ImageQueryFactory;
import com.projekt_zespolowy.tablica_ogloszen.predicate.factories.OfferQueryFactory;
import com.projekt_zespolowy.tablica_ogloszen.repositories.BasicRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Repository
public class CustomOfferRepositoryImpl extends BasicRepository implements CustomOfferRepository {

    private final Mapper imageMapper;

    @Override
    public Page<OfferPageView> findPage(Predicate predicate, Pageable pageable) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        JPAQuery<OfferPageView> query =
                queryFactory
                        .select(
                                Projections.constructor(
                                        OfferPageView.class,
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
        List<OfferPageView> data = this.getOneToManyRelations(query, queryFactory);
        long count = query.fetchCount();

        return new PageImpl<>(data, pageable, count);
    }

    protected List<OfferPageView> getOneToManyRelations(
            JPAQuery<OfferPageView> query, JPAQueryFactory queryFactory) {

        List<OfferPageView> data = query.fetch();
        for (OfferPageView row : data) {
            Long offerId = row.getId();
            List<ImageView> imageViews = this.getImageViews(offerId, queryFactory);
            if (imageViews != null && imageViews.size() >= 1) {
                row.setImage(imageViews.get(0));
            }
        }

        return data;
    }

    public List<ImageView> getImageViews(Long offerId, JPAQueryFactory queryFactory) {

        List<Image> entities = queryFactory.selectFrom(ImageQueryFactory.image()).where(ImageQueryFactory.offerId().eq(offerId)).fetch();
        List<ImageView> views = imageMapper.entitiesToViews(entities);

        return views;
    }

}
