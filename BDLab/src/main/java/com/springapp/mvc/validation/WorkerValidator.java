package com.springapp.mvc.validation;

/**
 * Created by Fleps_000 on 19.04.2015.
 */
import com.springapp.mvc.entity.Worker;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class WorkerValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return Worker.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "worker.name.empty");
        ValidationUtils.rejectIfEmpty(errors, "surname", "worker.surname.empty");
        ValidationUtils.rejectIfEmpty(errors, "patromymic", "worker.patromymic.empty");
        ValidationUtils.rejectIfEmpty(errors, "position", "worker.position.empty");
        ValidationUtils.rejectIfEmpty(errors, "salary", "worker.salary.empty");
        if(((Worker) target).getSalary()<0) {
            errors.rejectValue("price", "worker.salary.lessThanZero");
        }
    }

}
