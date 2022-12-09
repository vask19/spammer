package com.example.spammer.security;

import com.example.spammer.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {
    private final User user;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }
    @Override
    public String getUsername() {
        return user.getUsername();
    }
    @Override
    public boolean isAccountNonExpired() {
        return user.isActive();
    }
    @Override
    public boolean isAccountNonLocked() {
        return user.isActive();
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return user.isActive();
    }
    @Override
    public boolean isEnabled() {
        return user.isActive();
    }
    public User getUser() {
        return user;
    }
}
