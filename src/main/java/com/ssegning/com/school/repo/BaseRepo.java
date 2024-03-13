package com.ssegning.com.school.repo;

import io.github.thibaultmeyer.cuid.CUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepo<T> extends JpaRepository<T, CUID> {
}
