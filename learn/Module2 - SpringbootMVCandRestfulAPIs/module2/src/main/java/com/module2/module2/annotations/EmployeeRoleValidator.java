package com.module2.module2.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(
        validatedBy = EmployeeRoleValidatorImpl.class
)
public @interface EmployeeRoleValidator {
    String message() default "An employee must be either a USER or an ADMIN";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
