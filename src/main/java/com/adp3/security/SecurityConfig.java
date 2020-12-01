package com.adp3.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configurable
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private String USER_ROLE = "user";
    private String ADMIN_ROLE = "admin";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Super")
                .password(encoder().encode("Password.ADP3"))
                .roles("ADMIN","USER")
                .and()
                .withUser("User")
                .password(encoder().encode("Password"))
                .roles("USER");
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .antMatchers("/public/**").permitAll()
//            .anyRequest().authenticated()
//            .and()
//            .formLogin().loginPage("index.html")
//                .failureUrl("/login-error.html").permitAll();
//    }
@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and().formLogin().and().httpBasic();
    }
    @Bean
    public PasswordEncoder encoder(){
         return new BCryptPasswordEncoder();
    }
}
