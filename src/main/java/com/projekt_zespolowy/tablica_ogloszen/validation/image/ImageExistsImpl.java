package com.projekt_zespolowy.tablica_ogloszen.validation.image;

import com.projekt_zespolowy.tablica_ogloszen.repositories.image.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ImageExistsImpl implements ConstraintValidator<ImageExists, Long> {

    private final ImageRepository repository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {

        return repository.existsById(id);
    }

}