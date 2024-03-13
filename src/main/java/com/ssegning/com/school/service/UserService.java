package com.ssegning.com.school.service;

import com.ssegning.com.school.entity.BaseUser;
import com.ssegning.com.school.repo.StaffRepo;
import com.ssegning.com.school.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

// TODO
@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final StaffRepo staffRepo;
    private final StudentRepo studentRepo;

    public BaseUser loadByName(String name) {
        log.debug("Loading staff by name {}", name);
        BaseUser found = staffRepo.getStaffEntityByName(name);
        if (found == null) {
            log.debug("No staff with that name, trying with students");
            found = studentRepo.getStudentByName(name);
        }
        return found;
    }

}
