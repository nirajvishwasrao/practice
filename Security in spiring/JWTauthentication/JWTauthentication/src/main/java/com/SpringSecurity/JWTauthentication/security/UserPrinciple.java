package com.SpringSecurity.JWTauthentication.security;

import com.SpringSecurity.JWTauthentication.database_tables.Database_table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrinciple implements UserDetails {

    Database_table table;

    public UserPrinciple(Database_table table) {
        System.out.println("\n if table = null then bad credentials window will poppup");
        this.table=table;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton( new SimpleGrantedAuthority("USER"))  ;
    }

    @Override
    public String getPassword() {
        return table.getPassword();
    }

    @Override
    public String getUsername() {
        return table.getUsername();
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
