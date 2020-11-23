package com.projekt_zespolowy.tablica_ogloszen.mappers;

import com.projekt_zespolowy.tablica_ogloszen.models.offer.*;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                MapperClassService.class,
                MapperResolverService.class,
                ImageMapper.class,
                UserMapper.class,
                PriceMapper.class
        },
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class OfferMapper {

    @Named(value = "offerToView")
    public abstract OfferView entityToView(Offer entity);

    @IterableMapping(qualifiedByName = "offerToView")
    public abstract List<OfferView> entitiesToViews(List<Offer> entities);

    @Named(value = "offerToListView")
    public abstract OfferPageView entityToListView(Offer entity);

    @IterableMapping(qualifiedByName = "offerToListView")
    public abstract List<OfferPageView> entityToListView(List<Offer> entities);

    public abstract UpdateOfferForm entityToUpdateForm(Offer entity);

    @Mappings({
            @Mapping(target = "id", ignore = true)
            })
    public abstract Offer updateCmdToEntity(@MappingTarget Offer entity, UpdateOfferCmd cmd);

    public abstract Offer createCmdToEntity(CreateOfferCmd cmd);

}
