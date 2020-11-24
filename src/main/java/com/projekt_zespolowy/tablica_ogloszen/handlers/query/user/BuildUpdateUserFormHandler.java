package com.projekt_zespolowy.tablica_ogloszen.handlers.query.user;

import com.projekt_zespolowy.tablica_ogloszen.mappers.UserMapper;
import com.projekt_zespolowy.tablica_ogloszen.models.user.UpdateUserForm;
import com.projekt_zespolowy.tablica_ogloszen.models.user.User;
import com.projekt_zespolowy.tablica_ogloszen.predicate.models.user.UserIdPredicate;
import com.projekt_zespolowy.tablica_ogloszen.repositories.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BuildUpdateUserFormHandler {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UpdateUserForm handle(UserIdPredicate predicate) {

        User entity = this.repository.findById(predicate.getId()).orElse(new User());
        UpdateUserForm form = this.mapper.entityToUpdateForm(entity);

        return form;
    }

}
