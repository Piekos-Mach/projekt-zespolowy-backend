package com.projekt_zespolowy.tablica_ogloszen.handlers.command.offer;

import com.projekt_zespolowy.tablica_ogloszen.mappers.OfferMapper;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.CreateOfferCmd;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.Offer;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.OfferView;
import com.projekt_zespolowy.tablica_ogloszen.repositories.offer.OfferRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CreateOfferHandler {

    private final OfferRepository repository;
    private final OfferMapper mapper;

    @Transactional
    public OfferView handle(CreateOfferCmd cmd) {

        Offer entity = mapper.createCmdToEntity(cmd);
        entity = repository.save(entity);
        OfferView view = mapper.entityToView(entity);

        return view;
    }

}
