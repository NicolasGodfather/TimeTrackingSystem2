package com.asinovich.controllers.validator;

import com.asinovich.controllers.forms.EmployeeForm;
import com.asinovich.controllers.forms.ProjectForm;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Реализация
 *
 * @author Nicolas Asinovich.
 */
public class ProjectFormValidator implements Validator {
    @Override
    public boolean supports (Class<?> aClass) {
        return ProjectForm.class.equals(aClass);
    }

    @Override
    public void validate (Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "projectName", "valid.projectName.empty");
        EmployeeForm message = (EmployeeForm) o;
        if (message.getName().length() < 2 || message.getName().length() > 16) {
            errors.rejectValue("projectName", "valid.projectName.length");
        }
    }
}
