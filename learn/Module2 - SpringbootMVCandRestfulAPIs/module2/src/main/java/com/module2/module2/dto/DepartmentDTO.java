package com.module2.module2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class DepartmentDTO {
    private Long id;
    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NotNull
    private Boolean isActive;
    @NotNull
    private LocalDate createdAt;
}
