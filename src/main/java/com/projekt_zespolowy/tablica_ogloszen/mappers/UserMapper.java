package com.projekt_zespolowy.tablica_ogloszen.mappers;

import com.projekt_zespolowy.tablica_ogloszen.models.user.*;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(
        componentModel = "spring",
        uses = {MapperClassService.class, MapperResolverService.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class UserMapper {

    public abstract UserView entityToView(User user);

//    public abstract UpdateUserForm entityToUpdateForm(User entity);
//
//    public abstract User updateCmdToEntity(@MappingTarget User entity, UpdateUserCmd cmd);
//
//    public abstract UserView entityToView(User entity);

}
