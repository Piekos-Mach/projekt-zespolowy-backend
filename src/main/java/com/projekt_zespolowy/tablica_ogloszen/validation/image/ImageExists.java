package com.projekt_zespolowy.tablica_ogloszen.validation.image;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {ImageExistsImpl.class})
public @interface ImageExists {

    String message() default "{entity.exists}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
