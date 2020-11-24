package com.projekt_zespolowy.tablica_ogloszen.predicate.models.user;

import com.projekt_zespolowy.tablica_ogloszen.predicate.factories.QUserFactory;
import com.projekt_zespolowy.tablica_ogloszen.predicate.models.IdPredicate;
import com.querydsl.core.types.Predicate;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserIdPredicate extends IdPredicate {

    public UserIdPredicate(Long id) {
        super(id);
    }

    @Override
    public Predicate getIdPredicate() {

        return QUserFactory.id().eq(this.getId());
    }

}
