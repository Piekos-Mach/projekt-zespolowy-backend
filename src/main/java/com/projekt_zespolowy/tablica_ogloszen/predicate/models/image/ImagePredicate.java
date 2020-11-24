package com.projekt_zespolowy.tablica_ogloszen.predicate.models.image;

import com.projekt_zespolowy.tablica_ogloszen.predicate.models.EntityPredicate;
import com.querydsl.core.types.Predicate;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ImagePredicate extends EntityPredicate {

    public ImagePredicate(Predicate predicate) {
        super(predicate);
    }

    public Predicate getEntityPredicate() {

        return super.getEntityPredicate();
    }

}
