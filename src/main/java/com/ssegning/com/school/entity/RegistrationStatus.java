package com.ssegning.com.school.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RegistrationStatus {
    STARTED(1),
    DONE(0),
    CANCELLED(2);

    private final int status;

    @Override
    public String toString() {
        return "%s".formatted(status);
    }

    public boolean isDone() {
        return DONE == this;
    }

    public boolean isStarted() {
        return STARTED == this;
    }

    public static RegistrationStatus valueFrom(int v) {
        for (var value : RegistrationStatus.values()) {
            if (value.getStatus() == v) {
                return value;
            }
        }

        throw new IllegalArgumentException("%s is not a valid RegistrationStatus");
    }
}
