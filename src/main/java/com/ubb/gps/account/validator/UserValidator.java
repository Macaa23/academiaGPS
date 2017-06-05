/*package com.ubb.gps.account.validator;


import com.ubb.gps.account.model.User;
import com.ubb.gps.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "RUT", "NotEmpty");
        if (user.getRUT().length() < 8 || user.getRUT().length() > 9) {
            errors.rejectValue("RUT", "Size.userForm.RUT");
        }
        //Validar que el rut no esté registrado
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Nombre", "NotEmpty");
        if (user.getNombre().length() < 5 || user.getNombre().length() > 70) {
            errors.rejectValue("Nombre", "Size.userForm.Nombre");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "edad", "NotEmpty");
        if (user.getEdad().length()!= 2) {
            errors.rejectValue("edad", "Size.userForm.edad");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genero", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "NotEmpty");
              

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}*/