package com.module2.module2.dto;

import com.module2.module2.annotations.EmployeeRoleValidator;
import com.module2.module2.annotations.SalaryValidator;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
//    @NotNull(message = "name cannot be null")
//    @NotEmpty(message = "name cannot be empty")
//    @NotBlank(message = "name cannot be blank")
    @Size(min = 3, max = 10, message = "number of characters in name should be in range: [3, 10]")
    private String name;

    @NotBlank(message = "email cannot be blank")
    @Email(message = "invalid email")
    private String email;

//    @NotBlank(message = "age cannot be blank")
    @NotNull(message = "the age cannot be null")
    @Min(value = 18, message = "age cannot be less than 18")
    @Max(value = 80, message = "age cannot be greater than 80")
    private Integer age;

//    @NotBlank(message = "date of joining cannot be blank") no config for LocalDate
    @NotNull(message = "date of joining cannot be null")
    @PastOrPresent
    private LocalDate dateOfJoining;

    private Boolean isActive;

    @NotBlank(message = "the role cannot be null")
//    @Pattern(regexp = "^(ADMIN|admin|USER|user)$", message = "the role of employee can either be USER or ADMIN")
    @EmployeeRoleValidator
    private String role;

    @NotNull @SalaryValidator
    private Double salary;
}
