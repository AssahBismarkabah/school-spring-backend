package com.ssegning.com.school.repo;

import com.ssegning.com.school.entity.StaffEntity;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Repository;

// TODO add tests
@Repository
public interface StaffRepo extends BaseRepo<StaffEntity> {

    StaffEntity getStaffEntityByName(@NotNull String name);

}
