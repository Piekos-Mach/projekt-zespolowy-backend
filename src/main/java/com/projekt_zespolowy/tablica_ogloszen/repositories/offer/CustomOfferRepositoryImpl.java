package com.projekt_zespolowy.tablica_ogloszen.repositories.offer;

import com.projekt_zespolowy.tablica_ogloszen.mappers.ImageMapper;
import com.projekt_zespolowy.tablica_ogloszen.models.basic.BasicView;
import com.projekt_zespolowy.tablica_ogloszen.models.image.Image;
import com.projekt_zespolowy.tablica_ogloszen.models.image.ImageView;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.*;
import com.projekt_zespolowy.tablica_ogloszen.models.price.PriceView;
import com.projekt_zespolowy.tablica_ogloszen.models.user.UserView;
import com.projekt_zespolowy.tablica_ogloszen.predicate.factories.QImageFactory;
import com.projekt_zespolowy.tablica_ogloszen.predicate.factories.QOfferFactory;
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

    private final ImageMapper imageMapper;

    @Override
    public Page<OfferPageView> findPage(Predicate predicate, Pageable pageable) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        JPAQuery<OfferPageView> query =
                queryFactory
                        .select(
                                Projections.constructor(
                                        OfferPageView.class,
                                        QOfferFactory.id(),
                                        Projections.constructor(
                                                BasicView.class,
                                                QOfferFactory.ownerId(),
                                                QOfferFactory.ownerName()
                                        ),
                                        QOfferFactory.title(),
                                        QOfferFactory.text(),
                                        Projections.constructor(
                                                PriceView.class,
                                                QOfferFactory.priceValue(),
                                                Projections.constructor(BasicView.class,
                                                        QOfferFactory.priceCurrencyId(),
                                                        QOfferFactory.priceCurrencyName()
                                                )
                                        ),
                                        QOfferFactory.creationDate()
                                ))
                        .from(QOfferFactory.offer())
                        .where(predicate);
        if (pageable != null) {
            query
                    .orderBy(getOrderSpecifiers(pageable, Offer.class))
                    .limit(pageable.getPageSize())
                    .offset(pageable.getPageNumber() * pageable.getPageSize());
        } else {
            query.orderBy(QOfferFactory.id().asc());
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

        List<Image> entities = queryFactory.selectFrom(QImageFactory.image()).where(QImageFactory.offerId().eq(offerId)).fetch();
        List<ImageView> views = imageMapper.entitiesToViews(entities);

        return views;
    }

    @Override
    public Page<OfferPageViewL> findPageL(Predicate predicate, Pageable pageable) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        JPAQuery<OfferPageViewL> query =
                queryFactory
                        .select(
                                Projections.constructor(
                                        OfferPageViewL.class,
                                        QOfferFactory.id(),
                                        Projections.constructor(
                                                BasicView.class,
                                                QOfferFactory.ownerId(),
                                                QOfferFactory.ownerName()
                                        ),
                                        QOfferFactory.title(),
                                        QOfferFactory.text(),
                                        Projections.constructor(
                                                PriceView.class,
                                                QOfferFactory.priceValue(),
                                                Projections.constructor(BasicView.class,
                                                        QOfferFactory.priceCurrencyId(),
                                                        QOfferFactory.priceCurrencyName()
                                                )
                                        ),
                                        QOfferFactory.creationDate()
                                ))
                        .from(QOfferFactory.offer())
                        .where(predicate);
        if (pageable != null) {
            query
                    .orderBy(getOrderSpecifiers(pageable, Offer.class))
                    .limit(pageable.getPageSize())
                    .offset(pageable.getPageNumber() * pageable.getPageSize());
        } else {
            query.orderBy(QOfferFactory.id().asc());
        }
        List<OfferPageViewL> data = query.fetch();
        data = getMiniaturesId(data, queryFactory);
        long count = query.fetchCount();

        return new PageImpl<>(data, pageable, count);
    }

    protected List<OfferPageViewL> getMiniaturesId(
            List<OfferPageViewL> offersPage, JPAQueryFactory queryFactory) {

        for (OfferPageViewL offer : offersPage) {
            Long offerId = offer.getId();
            Long miniatureId = this.getMiniatureId(offerId, queryFactory);
            offer.setMiniature(miniatureId);
        }

        return offersPage;
    }

    public Long getMiniatureId(Long offerId, JPAQueryFactory queryFactory) {

        JPAQuery<Long> query = queryFactory
                .select(QImageFactory.id())
                .from(QImageFactory.image())
                .where(QImageFactory.offerId().eq(offerId));
        Long imageId = query.fetchFirst();

        return imageId;
    }

    public OfferViewL findViewById(Long id) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        JPAQuery<OfferViewL> query =
                queryFactory
                        .select(
                                Projections.constructor(
                                        OfferViewL.class,
                                        QOfferFactory.id(),
                                        Projections.constructor(
                                                UserView.class,
                                                QOfferFactory.ownerId(),
                                                QOfferFactory.ownerName(),
                                                Projections.constructor(
                                                        BasicView.class,
                                                        QOfferFactory.ownerTypeId(),
                                                        QOfferFactory.ownerTypeName()
                                                ),
                                                QOfferFactory.ownerMail()
                                        ),
                                        QOfferFactory.title(),
                                        QOfferFactory.text(),
                                        Projections.constructor(
                                                PriceView.class,
                                                QOfferFactory.priceValue(),
                                                Projections.constructor(BasicView.class,
                                                        QOfferFactory.priceCurrencyId(),
                                                        QOfferFactory.priceCurrencyName()
                                                )
                                        ),
                                        QOfferFactory.creationDate()
                                ))
                        .from(QOfferFactory.offer())
                        .where(QOfferFactory.id().eq(id));

        OfferViewL view = query.fetchFirst();
        List<Long> images = getImagesId(id, queryFactory);
        view.setImages(images);

        return view;

    }

    public List<Long> getImagesId(Long offerId, JPAQueryFactory queryFactory) {

        JPAQuery<Long> query = queryFactory
                .select(QImageFactory.id())
                .from(QImageFactory.image())
                .where(QImageFactory.offerId().eq(offerId));
        List<Long> imagesId = query.fetch();

        return imagesId;
    }

}
