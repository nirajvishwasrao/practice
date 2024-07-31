package com.SpringSecurity.JWTauthentication.security;

import com.SpringSecurity.JWTauthentication.Repositeries.sqltablerepo;
import com.SpringSecurity.JWTauthentication.database_tables.Database_table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    sqltablerepo repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("\n -> "+username+" <- <- <- <- loadUserByUsername  method called with this  entered data from browser   !!!!!!!!!");
        Database_table tabledata = repo.findByUsername(username);
        if (tabledata == null) {
            System.out.println(" ->\n table is not present");
            throw new UsernameNotFoundException(" -> not found my bro");


        }
        System.out.println(" ->  spring calls final methods called of UserPrinciple of type UserDetais " +
                "and passed table that got from database according to browser credentials \n");
        return new UserPrinciple(tabledata);
    }
}
