package com.projekt_zespolowy.tablica_ogloszen.repositories;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import lombok.NonNull;
import org.springframework.data.domain.Pageable;

public interface OrderSpecifierRepository {

    /**
     * Wykorzystywana przez repozytoria w celu posortowania i pobrania page'y z wynikami zapytań.
     *
     * @param pageable zawiera informacje o ilości obiektów na stronę i indeks strony
     * @param klass    klasa której dotyczą zapytania z repozitory
     * @return OrderSpecifier wykorzystywany przez repozytoria
     */
    default OrderSpecifier[] getOrderSpecifiers(@NonNull Pageable pageable, @NonNull Class klass) {

        // orderVariable must match the variable of FROM
        String className = klass.getSimpleName();
        final String orderVariable =
                String.valueOf(Character.toLowerCase(className.charAt(0))).concat(className.substring(1));

        return pageable.getSort().stream()
                .map(
                        order ->
                                new OrderSpecifier(
                                        Order.valueOf(order.getDirection().toString()),
                                        new PathBuilder(klass, orderVariable).get(order.getProperty())))
                .toArray(OrderSpecifier[]::new);
    }

}
