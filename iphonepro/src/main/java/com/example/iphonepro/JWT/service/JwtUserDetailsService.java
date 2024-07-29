package com.example.iphonepro.JWT.service;
import com.example.iphonepro.Repositeries.sqltablerepo;

import com.example.iphonepro.database_tables.Database_table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    sqltablerepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Database_table databaseTable = repo.findByUsername(username);
        if (databaseTable == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
       return User.builder()
               .username(databaseTable.getUsername())
               .password(databaseTable.getPassword())
               .build();
       // return new User(databaseTable.getUsername(), databaseTable.getPassword(), new ArrayList<>());
    }
}
