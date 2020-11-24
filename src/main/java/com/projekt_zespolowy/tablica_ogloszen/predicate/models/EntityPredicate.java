package com.projekt_zespolowy.tablica_ogloszen.predicate.models;

import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class EntityPredicate {

    private Predicate entityPredicate;

}
