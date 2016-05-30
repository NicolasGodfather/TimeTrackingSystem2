package com.asinovich.controllers.validator;

import com.asinovich.controllers.forms.EmployeeForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Реализация
 *
 * @author Nicolas Asinovich.
 */
@Component
public class EmployeeFormValidator implements Validator{

    public boolean supports (Class<?> aClass) {
        return EmployeeForm.class.equals(aClass);
    }

    public void validate (Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "valid.employeeName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "valid.employeeSurname.empty");
        EmployeeForm message = (EmployeeForm) o;
        if (message.getName().length() < 2 || message.getName().length() > 20) {
            errors.rejectValue("name", "valid.employeeName.length");
        }
        if (message.getSurname().length() < 2 || message.getSurname().length() > 20) {
            errors.rejectValue("surname", "valid.employeeSurname.length");
        }
    }
}
