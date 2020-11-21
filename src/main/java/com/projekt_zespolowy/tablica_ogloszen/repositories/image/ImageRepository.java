package com.projekt_zespolowy.tablica_ogloszen.repositories.image;

import com.projekt_zespolowy.tablica_ogloszen.models.image.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ImageRepository extends
        JpaRepository<Image, Long>,
        QuerydslPredicateExecutor<Image> {
}
