package com.projekt_zespolowy.tablica_ogloszen.handlers.command.offer;

import com.projekt_zespolowy.tablica_ogloszen.mappers.OfferMapper;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.Offer;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.OfferView;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.UpdateOfferCmd;
import com.projekt_zespolowy.tablica_ogloszen.repositories.offer.OfferRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UpdateOfferHandler {

    private final OfferRepository repository;
    private final OfferMapper mapper;

    @Transactional
    public OfferView handle(UpdateOfferCmd cmd) {

        Offer entity = repository.findById(cmd.getId()).orElseThrow(EntityExistsException::new);
        entity = mapper.updateCmdToEntity(entity, cmd);
        entity = repository.save(entity);
        OfferView view = mapper.entityToView(entity);

        return view;
    }

}