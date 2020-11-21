package com.projekt_zespolowy.tablica_ogloszen.repositories;

import com.projekt_zespolowy.tablica_ogloszen.models.basic.BasicView;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public interface BasicSelectRepository<Q> {

    default List<BasicView> findBasicSelectMethodBody(
            Predicate predicate,
            Optional<String> search,
            EntityManager entityManager,
            NumberPath<Long> idPath,
            StringPath namePath,
            Q entityPath) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        JPAQuery<BasicView> query =
                queryFactory
                        .select(Projections.constructor(BasicView.class, idPath, namePath))
                        .from((EntityPath<Q>) entityPath)
                        .where(predicate);
        if (search.isPresent()) {
            query = getSelectPredicate(search, query, idPath, namePath);
        }

        return query.fetch();
    }

    default JPAQuery<BasicView> getSelectPredicate(
            Optional<String> searchOptional,
            JPAQuery<BasicView> query,
            NumberPath<Long> idPath,
            StringPath namePath) {

        String search = searchOptional.get();
        String digits = search.replaceAll("\\D+", "");
        Long selectedId = digits.length() > 0 ? new Long(digits) : new Long(0);
        query = query.where(namePath.containsIgnoreCase(search).or(idPath.eq(selectedId)));

        return query;
    }

}
