package com.ssegning.com.school.entity;

import com.ssegning.com.school.converter.StaffRoleListConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "staff")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class StaffEntity extends BaseUser {

    @Column(name = "roles")
    @Convert(converter = StaffRoleListConverter.class)
    private Collection<StaffRole> roles;
}
