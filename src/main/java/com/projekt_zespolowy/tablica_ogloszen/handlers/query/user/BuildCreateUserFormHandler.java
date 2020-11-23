package com.projekt_zespolowy.tablica_ogloszen.handlers.query.user;

import com.projekt_zespolowy.tablica_ogloszen.models.user.CreateUserForm;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BuildCreateUserFormHandler {

    public CreateUserForm handle() {

        return new CreateUserForm();
    }

}
