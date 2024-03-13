package com.ssegning.com.school.model;

import com.ssegning.com.school.entity.BaseUser;
import com.ssegning.com.school.entity.StaffEntity;
import io.github.thibaultmeyer.cuid.CUID;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

// TODO
@RequiredArgsConstructor
public class BaseUserDetail implements UserDetails, Serializable {

    @NotNull
    private final BaseUser user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (user instanceof StaffEntity staff) {
            return staff.getRoles()
                    .stream()
                    .map(i -> new SimpleGrantedAuthority("ROLE_%s".formatted(i.name())))
                    .collect(Collectors.toSet());
        }
        return List.of();
    }

    public String getName() {
        return user.getName();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    public CUID getId() {
        return user.getId();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
