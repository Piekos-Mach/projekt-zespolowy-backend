package com.projekt_zespolowy.tablica_ogloszen.repositories.user;

import com.projekt_zespolowy.tablica_ogloszen.models.user.QUser;
import com.projekt_zespolowy.tablica_ogloszen.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

public interface UserRepository extends
        JpaRepository<User, Long>,
        QuerydslPredicateExecutor<User>,
        QuerydslBinderCustomizer<QUser> {

    @Override
    default void customize(QuerydslBindings querydslBindings, QUser qUser) {
    }

}
