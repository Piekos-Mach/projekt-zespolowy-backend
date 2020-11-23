package com.projekt_zespolowy.tablica_ogloszen.handlers.query.user;

import com.projekt_zespolowy.tablica_ogloszen.mappers.UserMapper;
import com.projekt_zespolowy.tablica_ogloszen.models.user.User;
import com.projekt_zespolowy.tablica_ogloszen.models.user.UserView;
import com.projekt_zespolowy.tablica_ogloszen.query.models.user.FindUserQuery;
import com.projekt_zespolowy.tablica_ogloszen.repositories.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ReadUserViewHandler {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserView handle(FindUserQuery query) {

        List<User> entities = (List<User>) this.repository.findAll(query.getPredicate());
        User entity = entities.size() == 1 ? entities.get(0) : new User();
        UserView viewModel = this.mapper.entityToView(entity);

        return viewModel;
    }

}
