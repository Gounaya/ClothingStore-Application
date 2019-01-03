package com.github.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = EmailUniqueValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {
    String message() default "{uniqueemail.error.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
