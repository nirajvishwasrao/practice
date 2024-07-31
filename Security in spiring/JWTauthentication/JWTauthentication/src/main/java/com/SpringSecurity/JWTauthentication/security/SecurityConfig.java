package com.SpringSecurity.JWTauthentication.security;

import com.SpringSecurity.JWTauthentication.JWT.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
//@EnableMethodSecurity
//@EnableOAuth2Sso
public class SecurityConfig {

    @Autowired
    MyUserDetailService userDetailsService;

    @Autowired
    JwtRequestFilter jwtRequestFilter;

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    //************  cheaking credentials in database   ****************************


    @Bean
    AuthenticationProvider authprovider() {
//        System.out.println("\n ->  SecurityConfig.authprovideer() ///  called by spring");

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

//        System.out.println(" ->  cheaks the object of type userdetailservice injected here and " +
//                " method called (when we press submit) internally Ex. myuserdetailservice.loadUserByUsername()  \n");

        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        // provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }

    //for login page / default login page / http basic defaults

    @Bean
    SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
       http
               .csrf(csrf->csrf.disable())
               .authorizeHttpRequests(authorise -> authorise
                       .requestMatchers("/authenticate").permitAll()
                       .anyRequest().authenticated())
               .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
       http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
