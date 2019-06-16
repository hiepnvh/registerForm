package com.mitrais.registerformdemo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mitrais.registerformdemo.model.User;
import com.mitrais.registerformdemo.service.UserService;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (userService.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate.userForm.email");
        }
        
        if (userService.findByMobileNumber(user.getMobileNumber()) != null) {
            errors.rejectValue("mobileNumber", "Duplicate.userForm.mobileNumber");
        }

    }
}
