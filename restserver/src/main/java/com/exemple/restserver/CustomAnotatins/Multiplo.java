package com.exemple.restserver.CustomAnotatins;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MultiploValidation.class)
public @interface Multiplo {
    String message() default "asdfsadfsdaf";

    Class<?>[] groups() default {};

    public abstract Class<? extends Payload>[] payload() default {};

}
