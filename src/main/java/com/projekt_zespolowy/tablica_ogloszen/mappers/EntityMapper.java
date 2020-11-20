package com.projekt_zespolowy.tablica_ogloszen.mappers;

public interface EntityMapper<Entity, View, CreateCmd, UpdateCmd, CreateForm, UpdateForm> {

    public abstract View entityToView(Entity entity);

}
