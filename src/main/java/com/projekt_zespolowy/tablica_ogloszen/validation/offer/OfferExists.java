package com.projekt_zespolowy.tablica_ogloszen.validation.offer;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {OfferExistsImpl.class})
public @interface OfferExists {

    String message() default "{entity.exists}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}