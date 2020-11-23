package com.projekt_zespolowy.tablica_ogloszen.handlers.command.offer;

import com.projekt_zespolowy.tablica_ogloszen.models.offer.DeleteOfferCmd;
import com.projekt_zespolowy.tablica_ogloszen.repositories.offer.OfferRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DeleteOfferHandler {

    private final OfferRepository repository;

    @Transactional
    public void handle(DeleteOfferCmd cmd) {

        repository.deleteById(cmd.getId());
    }

}