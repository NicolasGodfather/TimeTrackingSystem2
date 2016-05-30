package com.asinovich.controllers.validator;

import com.asinovich.controllers.forms.RecordSpentTimeForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Nicolas Asinovich.
 */
@Component
public class RecordSpentTimeFormValidator implements Validator {
    @Override
    public boolean supports (Class<?> aClass) {
        return RecordSpentTimeForm.class.equals(aClass);
    }

    @Override
    public void validate (Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numberOfHour", "valid.numberOfHour.empty");
        RecordSpentTimeForm message = (RecordSpentTimeForm) o;
        if (message.getNumberOfHour().length() < 1 || message.getNumberOfHour().length() > 3) {
            errors.rejectValue("numberOfHour", "valid.numberOfHour.length");
        }
        try {
            new Integer(message.getNumberOfHour());
        } catch (Exception e) {
            errors.rejectValue("numberOfHour", "valid.numberOfHour.notNumber");
        }
    }
}
