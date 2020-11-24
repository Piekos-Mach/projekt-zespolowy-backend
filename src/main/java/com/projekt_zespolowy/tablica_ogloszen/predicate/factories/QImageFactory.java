package com.projekt_zespolowy.tablica_ogloszen.predicate.factories;

import com.projekt_zespolowy.tablica_ogloszen.models.image.QImage;
import com.querydsl.core.types.dsl.ArrayPath;
import com.querydsl.core.types.dsl.NumberPath;


public class QImageFactory {

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

    public static ArrayPath<byte[], Byte> content() {
        return entityPath.content;
    }

}
