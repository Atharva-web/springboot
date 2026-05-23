package com.module2.module2.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SalaryValidatorImpl implements ConstraintValidator<SalaryValidator, Double> {

    @Override
    public boolean isValid(Double inputSalary, ConstraintValidatorContext constraintValidatorContext) {
        return inputSalary >= 30000;
    }
}
