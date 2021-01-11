package com.projekt_zespolowy.tablica_ogloszen.validation.user;

import com.projekt_zespolowy.tablica_ogloszen.validation.offer.OfferExistsImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {UserExistsImpl.class})
public @interface UserExists {

    String message() default "{entity.exists}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}