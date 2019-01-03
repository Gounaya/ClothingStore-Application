package com.github.validator;

import com.github.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUniqueValidator implements ConstraintValidator<UniqueEmail, String> {
    @Autowired
    private UserService userService;

    @Override
    public void initialize(UniqueEmail uniqueEmail) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext cxt) {
        if(email == null) {
            return false;
        }
        if(userService.findByEmail(email) == null){
            return true;
        }
        return false;
    }
}
