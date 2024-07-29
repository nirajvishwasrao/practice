package com.example.iphonepro.JWT.custome;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final UserDetails principal;
    private  String  token;


    public JwtAuthenticationToken(String token) {
        super(null);
        this.principal = null;
        this.token = token;
        setAuthenticated(false); // since the token is validated
    }

    public JwtAuthenticationToken(UserDetails principal,  Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        setAuthenticated(true); // since the token is validated
    }

    @Override
    public Object getCredentials() {
        return this.token;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }
}
