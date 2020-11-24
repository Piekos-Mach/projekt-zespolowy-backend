package com.projekt_zespolowy.tablica_ogloszen.repositories.image;

import com.projekt_zespolowy.tablica_ogloszen.models.image.ImageView;
import com.querydsl.core.types.Predicate;

import java.util.List;

public interface CustomImageRepository {

    public abstract ImageView findView(Long id);

    public abstract List<ImageView> findViews(Predicate predicate);

}
