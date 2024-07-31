package com.example.iphonepro.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
//@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfiguration {

    @Autowired
    MyUserDetailService userDetailsService;
//
//@Autowired
//    JwtRequestFilter jwtRequestFilter;


















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


//************ cheaking credentials in inmemory database e ****************************

//    @Bean
//    public UserDetailsService UserDetailsService() {
//
//        UserDetails user = User.withUsername("niraj")
//                .password(passwordEncoder().encode("niraj@1234"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user,admin);
//    }

// ******** cheaking credentials in DB with browser with ALERT no login form (view) *******************











    @Bean
    SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
//                .requestMatchers("/login2").permitAll()
//                .anyRequest().authenticated()

                        .anyRequest().authenticated()
//        ).formLogin((login)->login.loginPage("/login2")
//              .defaultSuccessUrl("/getjsp",true)
//              .permitAll()

        );


// i used ->               .sessionManagement(session -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                )
// Enable CSRF protection
        http.csrf(csrf -> csrf
                .ignoringRequestMatchers("/savedetails")
        );

        http.httpBasic(withDefaults());
//default login page
        //        http.formLogin(withDefaults());

        return http.build();
    }



//jwt :-
//
//
//@Bean
//AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration) throws Exception {
//       return authenticationConfiguration.getAuthenticationManager();
//}
//
//
//    @Bean
//    SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(authorise -> authorise
//                        .requestMatchers("/authenticate").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .sessionManagement(session -> session
//                       .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        http.addFilterBefore(jwtRequestFilter , UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
//










    // Will Execute This  ->  http://localhost:8080/login2?username=niraj&password=niraj@123
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
