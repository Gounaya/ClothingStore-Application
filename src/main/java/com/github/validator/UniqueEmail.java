package com.github.validator;

import org.springframework.context.annotation.Scope;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = EmailUniqueValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {
    String message() default "{uniqueemail.error.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
