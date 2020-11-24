package com.projekt_zespolowy.tablica_ogloszen.validation.offer;

import com.projekt_zespolowy.tablica_ogloszen.repositories.offer.OfferRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OfferExistsImpl implements ConstraintValidator<OfferExists, Long> {

    private final OfferRepository repository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {

        return repository.existsById(id);
    }

}