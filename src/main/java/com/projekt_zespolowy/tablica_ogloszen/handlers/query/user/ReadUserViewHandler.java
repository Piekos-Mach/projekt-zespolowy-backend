package com.projekt_zespolowy.tablica_ogloszen.handlers.query.user;

import com.projekt_zespolowy.tablica_ogloszen.mappers.UserMapper;
import com.projekt_zespolowy.tablica_ogloszen.models.user.User;
import com.projekt_zespolowy.tablica_ogloszen.models.user.UserView;
import com.projekt_zespolowy.tablica_ogloszen.predicate.models.user.UserPredicate;
import com.projekt_zespolowy.tablica_ogloszen.repositories.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ReadUserViewHandler {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserView handle(UserPredicate predicate) {

        User entity = this.repository.findById(predicate.getId()).orElse(new User());
        UserView viewModel = this.mapper.entityToView(entity);

        return viewModel;
    }

}
