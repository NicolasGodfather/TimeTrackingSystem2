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

    @Override
    public boolean supports (Class<?> aClass) {
        return EmployeeForm.class.equals(aClass);
    }

    @Override
    public void validate (Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "valid.employeeName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "valid.employeeSurname.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "position", "valid.employeePosition.empty");
        EmployeeForm message = (EmployeeForm) o;
        if (message.getName().length() < 2 || message.getName().length() > 16) {
            errors.rejectValue("name", "valid.employeeName.length");
        }
        if (message.getSurname().length() < 2 || message.getSurname().length() > 16) {
            errors.rejectValue("surname", "valid.employeeSurname.length");
        }
        if (message.getPosition().length() < 2 || message.getPosition().length() > 16) {
            errors.rejectValue("position", "valid.employeePosition.length");
        }
    }
}
