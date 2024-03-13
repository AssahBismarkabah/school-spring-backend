package com.ssegning.com.school.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public enum StaffRole implements Serializable {
    TEACHER("tc"),
    GATE_KEEPER("gk"),
    CLEANING("cl"),
    PRINCIPAL("p"),
    DisciplinaryMaster("dm");

    private final String name;

    public static StaffRole fromValue(String str) {
        for (StaffRole value : StaffRole.values()) {
            if (value.getName().equals(str)) {
                return value;
            }
        }

        throw new IllegalArgumentException("%s is not a valid StaffRole");
    }

    public String toString() {
        return name;
    }
}
