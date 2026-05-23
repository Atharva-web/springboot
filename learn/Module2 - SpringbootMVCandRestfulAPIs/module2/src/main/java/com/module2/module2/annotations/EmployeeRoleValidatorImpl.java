package com.module2.module2.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeeRoleValidatorImpl implements ConstraintValidator<EmployeeRoleValidator, String> {

    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext constraintValidatorContext) {
        List<String> roles = List.of("USER", "ADMIN");
        inputRole = inputRole.toUpperCase();
        return roles.contains(inputRole);
    }
}
