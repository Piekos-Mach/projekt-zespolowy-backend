package com.projekt_zespolowy.tablica_ogloszen.controllers.error;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestControllerAdvice
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ParamAndPathVariableValidationHandler {

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException exceptions, WebRequest request) {

        Set<ConstraintViolation<?>> constraintViolations = exceptions.getConstraintViolations();
        Map<String, List<String>> fieldErrorsValues = this.processConstraintViolations(constraintViolations);

        return ResponseEntity.badRequest().body(fieldErrorsValues);
    }

    private Map<String, List<String>> processConstraintViolations(Set<ConstraintViolation<?>> violations) {

        Map<String, List<String>> fieldErrorsValues = Maps.newHashMap();
        for (ConstraintViolation violation : violations) {
            String fieldName = violation.getPropertyPath().toString();
            fieldName = fieldName.substring(fieldName.indexOf(".") + 1);
            String message = violation.getMessage();
            if (fieldErrorsValues.containsKey(fieldName)) {
                List<String> processedFieldErrors = fieldErrorsValues.get(fieldName);
                processedFieldErrors.add(message);
            } else {
                fieldErrorsValues.put(fieldName, Lists.newArrayList(message));
            }
        }

        return fieldErrorsValues;
    }

}
