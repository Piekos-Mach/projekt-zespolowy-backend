package com.projekt_zespolowy.tablica_ogloszen.validation.user;

import com.projekt_zespolowy.tablica_ogloszen.repositories.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserExistsImpl implements ConstraintValidator<UserExists, Long> {

    private final UserRepository repository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {

        return repository.existsById(id);
    }

}
