package com.projekt_zespolowy.tablica_ogloszen.mappers;

import com.projekt_zespolowy.tablica_ogloszen.models.price.*;
import org.mapstruct.*;

@org.mapstruct.Mapper(
        componentModel = "spring",
        uses = {
                MapperClassService.class,
                MapperResolverService.class,
                ImageMapper.class,
                UserMapper.class,
                OfferMapper.class
        },
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class PriceMapper {

    public abstract PriceView instanceToView(Price instance);

    public abstract UpdatePriceForm instanceToUpdateForm(Price instance);

    public abstract Price instanceToCmd(@MappingTarget Price instance, UpdatePriceCmd cmd);

    public abstract Price createPriceCmdToInstance(CreatePriceCmd cmd);

}
