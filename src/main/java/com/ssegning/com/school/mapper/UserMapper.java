package com.ssegning.com.school.mapper;

import com.ssegning.com.school.entity.BaseUser;
import com.ssegning.com.school.model.BaseUserDetail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

// TODO
@Component
public class UserMapper {
    public UserDetails map(BaseUser user) {
        if (user == null) return null;
        return new BaseUserDetail(user);
    }
}
