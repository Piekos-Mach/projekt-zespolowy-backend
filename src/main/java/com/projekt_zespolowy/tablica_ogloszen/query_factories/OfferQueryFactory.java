package com.projekt_zespolowy.tablica_ogloszen.query_factories;

import com.projekt_zespolowy.tablica_ogloszen.models.offer.QOffer;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OfferQueryFactory {

    public static QOffer offer() {
        return QOffer.offer;
    }

    public static NumberPath<Long> id() {
        return QOffer.offer.id;
    }

    public static NumberPath<Long> ownerId() {
        return QOffer.offer.owner.id;
    }

    public static StringPath ownerName() {
        return QOffer.offer.owner.name;
    }

    public static NumberPath<Long> ownerTypeId() {
        return QOffer.offer.owner.type.id;
    }

    public static StringPath ownerTypeName() {
        return QOffer.offer.owner.type.name;
    }

    public static StringPath ownerMail() {
        return QOffer.offer.owner.mail;
    }

    public static StringPath title() {
        return QOffer.offer.title;
    }

    public static StringPath text() {
        return QOffer.offer.text;
    }

    public static NumberPath<BigDecimal> priceValue() {
        return QOffer.offer.price.value;
    }

    public static NumberPath<Long> priceCurrencyId() {
        return QOffer.offer.price.currency.id;
    }

    public static StringPath priceCurrencyName() {
        return QOffer.offer.price.currency.name;
    }

    public static DateTimePath<LocalDateTime> creationDate() {
        return QOffer.offer.creationDate;
    }

}
