package com.module3.SpringDataJPA.dto;

import com.module3.SpringDataJPA.enums.BloodGroups;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
public class BloodGroupStats {
    private final BloodGroups bloodGroup;
    private final Long count;
}
