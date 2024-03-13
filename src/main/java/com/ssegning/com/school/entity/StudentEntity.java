package com.ssegning.com.school.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "students")
@Entity
public class StudentEntity extends BaseUser {

    @Enumerated(EnumType.ORDINAL)
    private RegistrationStatus status;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
}
