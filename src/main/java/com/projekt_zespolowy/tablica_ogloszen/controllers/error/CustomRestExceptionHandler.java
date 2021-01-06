package com.projekt_zespolowy.tablica_ogloszen.controllers.error;

import com.projekt_zespolowy.tablica_ogloszen.exceptions.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CustomRestExceptionHandler {

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFound(EntityNotFoundException e) {

        return ResponseEntity.status(HttpStatus.CONFLICT).body(new Error(e.getMessage(), null));
    }

}

