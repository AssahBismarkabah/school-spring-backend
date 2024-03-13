package com.ssegning.com.school.repo;

import com.ssegning.com.school.entity.StudentEntity;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// TODO add tests
@Repository
public interface StudentRepo extends BaseRepo<StudentEntity> {

    StudentEntity getStudentEntityByName(@NotNull String name);

    @Query("SELECT s FROM StudentEntity s WHERE s.name = :name")
    StudentEntity getStudentByName(@Param("name") @NotNull String name);

}
