package com.projekt_zespolowy.tablica_ogloszen.repositories;

import com.projekt_zespolowy.tablica_ogloszen.query.models.SortingOrder;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.*;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mapping.PropertyPath;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;

public class CustomQueryDslRepositoryExtensionImpl<T, Q extends EntityPathBase<T>>
        implements CustomQueryDslRepositoryExtension<T, Q> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<T> findAll(
            Q qClass, Predicate predicate, Pageable pageable, SortingOrder sortingOrder) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        Iterator iterator = pageable.getSort().iterator();
        JPAQuery query =
                queryFactory
                        .select(qClass)
                        .from(qClass)
                        .where(predicate)
                        .limit((long) pageable.getPageSize())
                        .offset(pageable.getOffset());
        while (iterator.hasNext()) {
            Sort.Order order = (Sort.Order) iterator.next();
            PropertyPath path = PropertyPath.from(order.getProperty(), qClass.getType());
            Expression property;
            for (property = qClass; path != null; path = path.next()) {
                if (!path.hasNext() && order.isIgnoreCase()) {
                    property = Expressions.stringPath((Path) property, path.getSegment()).lower();
                } else {
                    property = Expressions.stringPath((Path) property, path.getSegment());
                }
            }
            CaseBuilder.Cases<Integer, NumberExpression<Integer>> cases =
                    new CaseBuilder()
                            .when(((StringPath) property).eq(sortingOrder.getValuesOrder().get(0)))
                            .then(0);
            for (int i = 1; i < sortingOrder.getValuesOrder().size(); i++) {
                cases.when(((StringPath) property).eq(sortingOrder.getValuesOrder().get(i))).then(i);
            }
            NumberExpression expr = cases.otherwise(sortingOrder.getValuesOrder().size());
            if (order.isAscending()) {
                query.orderBy(expr.asc());
            } else {
                query.orderBy(expr.desc());
            }
        }
        List<T> list = query.fetch();

        return new PageImpl<>(list, pageable, query.fetchCount());
    }

}

