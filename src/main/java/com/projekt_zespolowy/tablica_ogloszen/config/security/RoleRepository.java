package com.projekt_zespolowy.tablica_ogloszen.config.security;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository
    extends CrudRepository<Role, Long>,
    QuerydslPredicateExecutor<Role> {

}
