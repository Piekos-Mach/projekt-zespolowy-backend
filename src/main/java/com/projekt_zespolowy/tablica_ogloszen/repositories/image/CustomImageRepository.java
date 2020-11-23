package com.projekt_zespolowy.tablica_ogloszen.repositories.image;

import com.projekt_zespolowy.tablica_ogloszen.models.image.ImageView;

public interface CustomImageRepository {

    public abstract ImageView findView(Long id);

}
