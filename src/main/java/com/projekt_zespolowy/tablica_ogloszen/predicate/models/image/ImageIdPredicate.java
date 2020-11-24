package com.projekt_zespolowy.tablica_ogloszen.predicate.models.image;

import com.projekt_zespolowy.tablica_ogloszen.predicate.factories.QImageFactory;
import com.projekt_zespolowy.tablica_ogloszen.predicate.models.IdPredicate;
import com.querydsl.core.types.Predicate;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ImageIdPredicate extends IdPredicate {

    public ImageIdPredicate(Long id) {
        super(id);
    }

    public Predicate getIdPredicate() {

        return QImageFactory.id().eq(super.getId());
    }

}
