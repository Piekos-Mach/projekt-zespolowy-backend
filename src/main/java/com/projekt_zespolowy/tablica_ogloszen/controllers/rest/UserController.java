package com.projekt_zespolowy.tablica_ogloszen.controllers.rest;

import com.projekt_zespolowy.tablica_ogloszen.handlers.command.user.CreateUserHandler;
import com.projekt_zespolowy.tablica_ogloszen.handlers.command.user.DeleteUserHandler;
import com.projekt_zespolowy.tablica_ogloszen.handlers.command.user.UpdateUserHandler;
import com.projekt_zespolowy.tablica_ogloszen.handlers.query.user.BuildCreateUserFormHandler;
import com.projekt_zespolowy.tablica_ogloszen.handlers.query.user.BuildUpdateUserFormHandler;
import com.projekt_zespolowy.tablica_ogloszen.handlers.query.user.ReadUserViewHandler;
import com.projekt_zespolowy.tablica_ogloszen.models.user.*;
import com.projekt_zespolowy.tablica_ogloszen.predicate.models.user.UserIdPredicate;
import com.projekt_zespolowy.tablica_ogloszen.validation.DefaultSequence;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated(DefaultSequence.class)
@RestController
@RequestMapping("users")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final CreateUserHandler createHandler;
    private final UpdateUserHandler updateHandler;
    private final DeleteUserHandler deleteHandler;
    private final ReadUserViewHandler readViewHandler;
    private final BuildUpdateUserFormHandler buildUpdateFormHandler;
    private final BuildCreateUserFormHandler buildCreateFormHandler;

    @PostMapping
    public ResponseEntity<UserView> create(@Validated(DefaultSequence.class) @RequestBody CreateUserCmd cmd) {

        UserView viewModel = this.createHandler.handle(cmd);

        return ResponseEntity.ok(viewModel);
    }

    // TODO: przyklad wymogu roli
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @PutMapping
    public ResponseEntity<UserView> update(@Validated(DefaultSequence.class) @RequestBody UpdateUserCmd cmd) {

        UserView viewModel = this.updateHandler.handle(cmd);

        return ResponseEntity.ok(viewModel);
    }

    @PostMapping(value = "/d")
    public ResponseEntity delete(@Validated(DefaultSequence.class) @RequestBody DeleteUserCmd cmd) {

        this.deleteHandler.handle(cmd);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/rv")
    public ResponseEntity<UserView> readView(@Validated(DefaultSequence.class) @RequestBody UserIdPredicate predicate) {

        UserView viewModel = this.readViewHandler.handle(predicate);

        return ResponseEntity.ok(viewModel);
    }

    @GetMapping(value = "/buf")
    public ResponseEntity<UpdateUserForm> buildUpdateForm(@Validated(DefaultSequence.class) @RequestBody UserIdPredicate predicate) {

        UpdateUserForm form = this.buildUpdateFormHandler.handle(predicate);

        return ResponseEntity.ok(form);
    }

    @GetMapping(value = "/bcf")
    public ResponseEntity<CreateUserForm> buildCreateForm() {

        CreateUserForm form = this.buildCreateFormHandler.handle();

        return ResponseEntity.ok(form);
    }

}
