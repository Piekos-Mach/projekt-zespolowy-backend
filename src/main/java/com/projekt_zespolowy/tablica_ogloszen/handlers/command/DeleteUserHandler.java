package com.projekt_zespolowy.tablica_ogloszen.handlers.command;

import com.projekt_zespolowy.tablica_ogloszen.models.user.DeleteUserCmd;
import com.projekt_zespolowy.tablica_ogloszen.repositories.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DeleteUserHandler {

    private final UserRepository repository;

    @Transactional
    public void handle(DeleteUserCmd cmd) {

        repository.deleteById(cmd.getId());
    }

}
