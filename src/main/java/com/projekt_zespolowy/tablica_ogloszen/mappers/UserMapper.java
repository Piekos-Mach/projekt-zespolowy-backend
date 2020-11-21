package com.projekt_zespolowy.tablica_ogloszen.mappers;

import com.projekt_zespolowy.tablica_ogloszen.models.user.*;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        uses = {
                MapperClassService.class,
                MapperResolverService.class,
                ImageMapper.class,
                OfferMapper.class,
                PriceMapper.class
        },
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class UserMapper {

    public abstract UserView entityToView(User entity);

    public abstract UpdateUserForm entityToUpdateForm(User entity);

    @Mappings({@Mapping(target = "id", ignore = true)})
    public abstract User updateCmdToEntity(@MappingTarget User entity, UpdateUserCmd cmd);

    public abstract User createCmdToEntity(CreateUserCmd cmd);

}
