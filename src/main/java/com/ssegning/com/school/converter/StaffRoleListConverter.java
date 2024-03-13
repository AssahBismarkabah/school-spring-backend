package com.ssegning.com.school.converter;

import com.ssegning.com.school.entity.StaffRole;
import jakarta.persistence.Converter;

@Converter
public class StaffRoleListConverter extends CollectionConverter<StaffRole> {
    public StaffRoleListConverter() {
        super(new StaffRoleConverter());
    }
}
