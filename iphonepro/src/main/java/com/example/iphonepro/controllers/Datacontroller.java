package com.example.iphonepro.controllers;

import com.example.iphonepro.database_tables.Database_table;
import com.example.iphonepro.Repositeries.sqltablerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller

public class Datacontroller {
    @Autowired
    sqltablerepo repo;
    @Autowired
    PasswordEncoder encoder;
    int a = 0;

    @PostMapping("/savedetails")
    public String savedatails(@ModelAttribute Database_table databaseTable) {

        String pass = databaseTable.getPassword();
        databaseTable.setPassword(encoder.encode(pass));
        repo.save(databaseTable);
        return "showtable.jsp";
    }


    @GetMapping("/gettable")
    public List<Database_table> getmysqltable() {

        return repo.findAll();

    }

    //for inmemorry we use @PreAu...
//@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/getjsp")
    public String getaccess() {
        System.out.println("in getjsp");
        return "index.jsp";
    }

    @RequestMapping("/login2")
    public String getlogin() {
        System.out.println("here in get login");

        return "Login.jsp";
    }

    @RequestMapping("/register")
    public String register() {
        return "Register.jsp";
    }

    @ResponseBody
    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }
}
