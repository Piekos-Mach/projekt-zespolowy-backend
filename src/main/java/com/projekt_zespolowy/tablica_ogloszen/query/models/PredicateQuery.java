package com.projekt_zespolowy.tablica_ogloszen.query.models;

import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PredicateQuery {

    private Predicate predicate;

}