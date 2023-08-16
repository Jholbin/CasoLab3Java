package com.example.cibertec.CL3.CasoLab3;

import java.net.http.HttpRequest;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfiguration {
    
    @Bean
    public UserDetailsService getUserDetailsService() {
        User jholbin = new User("jholbin",
         getPasswordEncoder().encode("123456"),
         Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));

         User pedro = new User("pedro",
         getPasswordEncoder().encode("123456"),
         Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));

        return new InMemoryUserDetailsManager(jholbin, pedro);        
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {

        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
        .authorizeHttpRequests(httpRequest ->
            httpRequest
            .requestMatchers("/").permitAll()
            .requestMatchers("/empleados").permitAll()
            .requestMatchers("/empleados/create").authenticated()
            .requestMatchers("/empleados/{id}").authenticated()
            .requestMatchers("/empleados/{id}/edit").authenticated()
            .requestMatchers("/empleados/{id}/delete").authenticated()
        )
        .formLogin(formLogin -> formLogin.loginPage("/login").permitAll())
        .logout(logout -> 
                logout
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/empleados")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID"))
        .build();
    }



}
