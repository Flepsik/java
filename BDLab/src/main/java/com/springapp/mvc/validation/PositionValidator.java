package com.springapp.mvc.validation;

/**
 * Created by Fleps_000 on 19.04.2015.
 */
import com.springapp.mvc.entity.Position;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PositionValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return Position.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "service.name.empty");
    }

}
