package com.treehouse.zag.core;

import com.treehouse.zag.user.DetailsService;
import com.treehouse.zag.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created @author sobchak on 6/25/17.
 */
@Configuration
@EnableWebSecurity // Lets Spring Security know about this
@EnableGlobalMethodSecurity(prePostEnabled = true) // This will secure our methods
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(User.PASSWORD_ENCODER); // Knows how to decrypt
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable(); // Don't do this on production!!! This is solely for testing.
    }
}
