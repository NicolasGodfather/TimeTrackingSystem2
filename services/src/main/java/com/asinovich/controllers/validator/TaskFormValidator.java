package com.asinovich.controllers.validator;

import com.asinovich.controllers.forms.TaskForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Nicolas Asinovich.
 */
@Component
public class TaskFormValidator implements Validator{
    @Override
    public boolean supports (Class<?> aClass) {
        return TaskForm.class.equals(aClass);
    }

    @Override
    public void validate (Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "taskName", "valid.taskName.empty");
        TaskForm message = (TaskForm) o;
        if (message.getTaskName().length() < 4 || message.getTaskName().length() > 16) {
            errors.rejectValue("taskName", "valid.taskName.length");
        }
    }
}
