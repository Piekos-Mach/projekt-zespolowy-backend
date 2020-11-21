package com.projekt_zespolowy.tablica_ogloszen.query.factories;

import com.projekt_zespolowy.tablica_ogloszen.models.image.QImage;
import com.querydsl.core.types.dsl.NumberPath;


public class ImageQueryFactory {

    private final static QImage entityPath = QImage.image;

    public static QImage image() {
        return entityPath;
    }

    public static NumberPath<Long> id() {
        return entityPath.id;
    }

    public static NumberPath<Long> offerId() {
        return entityPath.offer.id;
    }

}
