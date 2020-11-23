package com.projekt_zespolowy.tablica_ogloszen.handlers.query.user;

import com.projekt_zespolowy.tablica_ogloszen.mappers.UserMapper;
import com.projekt_zespolowy.tablica_ogloszen.models.user.UpdateUserForm;
import com.projekt_zespolowy.tablica_ogloszen.models.user.User;
import com.projekt_zespolowy.tablica_ogloszen.query.models.user.FindUserQuery;
import com.projekt_zespolowy.tablica_ogloszen.repositories.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BuildUpdateUserFormHandler {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UpdateUserForm handle(FindUserQuery query) {

        List<User> entities = (List<User>) repository.findAll(query.getPredicate());
        User entity = entities.size() == 1 ? entities.get(0) : new User();
        UpdateUserForm form = this.mapper.entityToUpdateForm(entity);

        return form;
    }

}
