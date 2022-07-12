package com.tinapplication.smartphonewars.security;

import com.tinapplication.smartphonewars.entities.Gamer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class UserData implements UserDetails {
    private final long id;
    private final String username;
    private final String password;
    private final List<GrantedAuthority> roles;

    public UserData(Gamer gamer) {
        this.id = gamer.getGamerId();
        this.username = gamer.getName();
        this.password = gamer.getPassword();
        this.roles = Collections.singletonList(new SimpleGrantedAuthority(gamer.getRole().name()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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

    public long getId() {
        return this.id;
    }
}
