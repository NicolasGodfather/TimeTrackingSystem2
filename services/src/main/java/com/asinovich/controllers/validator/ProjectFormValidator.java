package com.asinovich.controllers.validator;

import com.asinovich.controllers.forms.ProjectForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Nicolas Asinovich.
 */
@Component
public class ProjectFormValidator implements Validator {

    @Override
    public boolean supports (Class<?> aClass) {
        return ProjectForm.class.equals(aClass);
    }

    @Override
    public void validate (Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "projectName", "valid.projectName.empty");
        ProjectForm message = (ProjectForm) o;
        if (message.getProjectName().length() < 4 || message.getProjectName().length() > 16) {
            errors.rejectValue("projectName", "valid.projectName.length");
        }
    }
}
