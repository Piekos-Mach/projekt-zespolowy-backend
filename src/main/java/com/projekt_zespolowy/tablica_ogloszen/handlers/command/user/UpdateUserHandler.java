package com.projekt_zespolowy.tablica_ogloszen.handlers.command.user;

import com.projekt_zespolowy.tablica_ogloszen.mappers.UserMapper;
import com.projekt_zespolowy.tablica_ogloszen.models.user.CreateUserCmd;
import com.projekt_zespolowy.tablica_ogloszen.models.user.UpdateUserCmd;
import com.projekt_zespolowy.tablica_ogloszen.models.user.User;
import com.projekt_zespolowy.tablica_ogloszen.models.user.UserView;
import com.projekt_zespolowy.tablica_ogloszen.repositories.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UpdateUserHandler {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Transactional
    public UserView handle(UpdateUserCmd cmd) {

        User entity = repository.findById(cmd.getId()).orElseThrow(EntityExistsException::new);
        entity = mapper.updateCmdToEntity(entity, cmd);
        entity = repository.save(entity);
        UserView view = mapper.entityToView(entity);

        return view;
    }

}
