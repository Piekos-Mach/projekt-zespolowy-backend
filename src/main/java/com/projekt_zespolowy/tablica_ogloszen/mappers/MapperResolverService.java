package com.projekt_zespolowy.tablica_ogloszen.mappers;

import com.projekt_zespolowy.tablica_ogloszen.models.image.Image;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.Offer;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.OfferStatus;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.OfferType;
import com.projekt_zespolowy.tablica_ogloszen.models.price.Currency;
import com.projekt_zespolowy.tablica_ogloszen.models.user.User;
import com.projekt_zespolowy.tablica_ogloszen.models.user.UserType;
import com.projekt_zespolowy.tablica_ogloszen.repositories.image.ImageRepository;
import com.projekt_zespolowy.tablica_ogloszen.repositories.offer.OfferRepository;
import com.projekt_zespolowy.tablica_ogloszen.repositories.offer.OfferStatusRepository;
import com.projekt_zespolowy.tablica_ogloszen.repositories.offer.OfferTypeRepository;
import com.projekt_zespolowy.tablica_ogloszen.repositories.price.CurrencyRepository;
import com.projekt_zespolowy.tablica_ogloszen.repositories.user.UserRepository;
import com.projekt_zespolowy.tablica_ogloszen.repositories.user.UserTypeRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.TargetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MapperResolverService {

    private final UserRepository userRepository;
    private final UserTypeRepository userTypeRepository;
    private final OfferRepository offerRepository;
    private final OfferTypeRepository offerTypeRepository;
    private final OfferStatusRepository offerStatusRepository;
    private final ImageRepository imageRepository;
    private final CurrencyRepository currencyRepository;

    public User toUser(Long id, @TargetType Class<User> type) {
        return id != null ? userRepository.findById(id).orElse(null) : null;
    }

    public UserType toUserType(Long id, @TargetType Class<UserType> type) {
        return id != null ? userTypeRepository.findById(id).orElse(null) : null;
    }

    public Offer toOffer(Long id, @TargetType Class<Offer> type) {
        return id != null ? offerRepository.findById(id).orElse(null) : null;
    }

    public OfferType toOfferType(Long id, @TargetType Class<OfferType> type) {
        return id != null ? offerTypeRepository.findById(id).orElse(null) : null;
    }

    public OfferStatus toOfferStatus(Long id, @TargetType Class<OfferStatus> type) {
        return id != null ? offerStatusRepository.findById(id).orElse(null) : null;
    }

    public Image toImage(Long id, @TargetType Class<Image> type) {
        return id != null ? imageRepository.findById(id).orElse(null) : null;
    }

    public Currency toCurrency(Long id, @TargetType Class<Currency> type) {
        return id != null ? currencyRepository.findById(id).orElse(null) : null;
    }

}
