package com.projekt_zespolowy.tablica_ogloszen.predicate.factories;

import com.projekt_zespolowy.tablica_ogloszen.models.user.QUser;
import com.querydsl.core.types.dsl.NumberPath;

public class QUserFactory {

    private static final QUser entityPath = QUser.user;

    public static QUser user() {
        return entityPath;
    }

    public static NumberPath<Long> id() {
        return entityPath.id;
    }

}
