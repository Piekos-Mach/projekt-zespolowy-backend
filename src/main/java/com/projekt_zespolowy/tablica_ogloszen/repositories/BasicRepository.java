package com.projekt_zespolowy.tablica_ogloszen.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BasicRepository {

    @PersistenceContext
    protected EntityManager entityManager;

}
