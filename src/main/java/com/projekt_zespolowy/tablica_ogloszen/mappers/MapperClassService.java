package com.projekt_zespolowy.tablica_ogloszen.mappers;

import com.projekt_zespolowy.tablica_ogloszen.models.image.Image;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.Offer;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.OfferStatus;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.OfferType;
import com.projekt_zespolowy.tablica_ogloszen.models.price.Currency;
import com.projekt_zespolowy.tablica_ogloszen.models.user.User;
import com.projekt_zespolowy.tablica_ogloszen.models.user.UserType;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Service;

@Service
public abstract class MapperClassService {

    public Long userToLong(User entity, @TargetType Class<Long> type) {
        return entity == null ? null : entity.getId();
    }

    public Long userTypeToLong(UserType entity, @TargetType Class<Long> type) {
        return entity == null ? null : entity.getId();
    }

    public Long offerTypeToLong(Offer entity, @TargetType Class<Long> type) {
        return entity == null ? null : entity.getId();
    }

    public Long offerTypeToLong(OfferType entity, @TargetType Class<Long> type) {
        return entity == null ? null : entity.getId();
    }

    public Long offerStatusToLong(OfferStatus entity, @TargetType Class<Long> type) {
        return entity == null ? null : entity.getId();
    }

    public Long currencyToLong(Currency entity, @TargetType Class<Long> type) {
        return entity == null ? null : entity.getId();
    }

}
