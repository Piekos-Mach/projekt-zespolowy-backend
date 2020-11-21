package com.projekt_zespolowy.tablica_ogloszen.query.factories;

import com.projekt_zespolowy.tablica_ogloszen.models.offer.QOffer;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OfferQueryFactory {

    private static final QOffer entityPath = QOffer.offer;

    public static QOffer offer() {
        return entityPath;
    }

    public static NumberPath<Long> id() {
        return entityPath.id;
    }

    public static NumberPath<Long> ownerId() {
        return entityPath.owner.id;
    }

    public static StringPath ownerName() {
        return entityPath.owner.name;
    }

    public static NumberPath<Long> ownerTypeId() {
        return entityPath.owner.type.id;
    }

    public static StringPath ownerTypeName() {
        return entityPath.owner.type.name;
    }

    public static StringPath ownerMail() {
        return entityPath.owner.mail;
    }

    public static StringPath title() {
        return entityPath.title;
    }

    public static StringPath text() {
        return entityPath.text;
    }

    public static NumberPath<BigDecimal> priceValue() {
        return entityPath.price.value;
    }

    public static NumberPath<Long> priceCurrencyId() {
        return entityPath.price.currency.id;
    }

    public static StringPath priceCurrencyName() {
        return entityPath.price.currency.name;
    }

    public static DateTimePath<LocalDateTime> creationDate() {
        return entityPath.creationDate;
    }

}
