package com.projekt_zespolowy.tablica_ogloszen.predicate.models;

import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class PagePredicate {

    private Predicate predicate;
    private Pageable pageable;

}
