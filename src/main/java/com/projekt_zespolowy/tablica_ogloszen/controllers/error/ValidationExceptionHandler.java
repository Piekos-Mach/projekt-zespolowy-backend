package com.projekt_zespolowy.tablica_ogloszen.controllers.error;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.projekt_zespolowy.tablica_ogloszen.exceptions.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

    private final ObjectErrorToFieldTranslatorService objectErrorToFieldTranslatorService;

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    ResponseEntity<?> handleEntityNotFound(EntityNotFoundException e) {

        return ResponseEntity.status(HttpStatus.CONFLICT).body(new Error(e.getMessage(), null));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        BindingResult result = ex.getBindingResult();
        List<ObjectError> objectErrors = result.getAllErrors();
        List<FieldError> fieldErrors = result.getFieldErrors();
        Map<String, List<String>> fieldErrorsValues = processFieldErrors(fieldErrors);
        Map<String, List<String>> objectErrorsValues = processObjectErrors(objectErrors);

        return ResponseEntity.badRequest().body(combineErrors(fieldErrorsValues, objectErrorsValues));
    }

    private Map<String, List<String>> processFieldErrors(List<FieldError> fieldErrors) {

        Map<String, List<String>> errors = Maps.newLinkedHashMap();
        for (FieldError fieldError : fieldErrors) {
            if (errors.containsKey(fieldError.getField())) {
                List<String> currentFieldErrors = errors.get(fieldError.getField());
                currentFieldErrors.add(fieldError.getDefaultMessage());
                errors.replace(fieldError.getField(), currentFieldErrors);
            } else {
                errors.put(fieldError.getField(), Lists.newArrayList(fieldError.getDefaultMessage()));
            }
        }

        return errors;
    }

    private Map<String, List<String>> processObjectErrors(List<ObjectError> objectErrors) {

        Map<String, List<String>> errors = Maps.newLinkedHashMap();
        for (ObjectError objectError : objectErrors) {
            String[] codes = objectError.getCodes();
            String tmpCode = codes.length >= 2 ? codes[1] : codes[0];
            String code = objectErrorToFieldTranslatorService.translateObjectError(tmpCode);
            if (errors.containsKey(code)) {
                List<String> currentFieldErrors = errors.get(code);
                currentFieldErrors.add(objectError.getDefaultMessage());
                errors.replace(code, currentFieldErrors);
            } else {
                errors.put(code, Lists.newArrayList(objectError.getDefaultMessage()));
            }
        }

        return errors;
    }

    private Map<String, List<String>> combineErrors(
            Map<String, List<String>> map1, Map<String, List<String>> map2) {

        Map<String, List<String>> map3 = new LinkedHashMap<>(map2);
        map1.forEach(map3::putIfAbsent);

        return map3;
    }

}

