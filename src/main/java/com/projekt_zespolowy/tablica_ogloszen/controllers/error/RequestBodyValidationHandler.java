package com.projekt_zespolowy.tablica_ogloszen.controllers.error;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.List;
import java.util.Map;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RequestBodyValidationHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        Map<String, List<String>> fieldErrorsValues = processFieldErrors(fieldErrors);

        return ResponseEntity.badRequest().body(fieldErrorsValues);
    }

    private Map<String, List<String>> processFieldErrors(List<FieldError> fieldErrors) {

        Map<String, List<String>> processedErrors = Maps.newLinkedHashMap();
        for (FieldError fieldError : fieldErrors) {
            if (processedErrors.containsKey(fieldError.getField())) {
                List<String> processedFieldErrors = processedErrors.get(fieldError.getField());
                processedFieldErrors.add(fieldError.getDefaultMessage());
            } else {
                processedErrors.put(fieldError.getField(), Lists.newArrayList(fieldError.getDefaultMessage()));
            }
        }

        return processedErrors;
    }

}
