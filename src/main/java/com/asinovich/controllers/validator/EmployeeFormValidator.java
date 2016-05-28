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
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "valid.employeeFirstName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "valid.employeeLastName.empty");
        EmployeeForm message = (EmployeeForm) o;
        if (message.getFirstName().length() < 2 || message.getFirstName().length() > 20) {
            errors.rejectValue("firstName", "valid.employeeFirstName.length");
        }
        if (message.getLastName().length() < 2 || message.getLastName().length() > 20) {
            errors.rejectValue("lastName", "valid.employeeLastName.length");
        }
    }
}
