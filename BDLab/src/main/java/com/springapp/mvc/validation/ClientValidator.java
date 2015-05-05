package com.springapp.mvc.validation;

import com.springapp.mvc.entity.Client;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Fleps_000 on 18.04.2015.
 */
@Component
public class ClientValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return Client.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "worker.name.empty");
        ValidationUtils.rejectIfEmpty(errors, "surname", "worker.surname.empty");
        String phone = ((Client) target).getPhone();
        if (phone.length()<11) {
            errors.rejectValue("phone", "client.phone.lessThan11");
        }

    }

}
