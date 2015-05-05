package com.springapp.mvc.validation;

/**
 * Created by Fleps_000 on 19.04.2015.
 */

import com.springapp.mvc.entity.Service;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ServiceValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return Service.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Service service = (Service) target;
        ValidationUtils.rejectIfEmpty(errors, "name", "service.name.empty");
        ValidationUtils.rejectIfEmpty(errors, "price", "service.price.empty");

        if (service.getPrice()<0)
            errors.rejectValue("price", "service.price.lessThanZero");

    }

}
