package com.ikpil.book_spring_boot_meets_fastest.ch3;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // security.basic.enabled: false 해당 옵션이 없어졌기 때문에, 일단 코드로 구현해야 한다
        // https://stackoverflow.com/questions/49717573/property-security-basic-enabled-is-deprecated-the-security-auto-configuration
        http.authorizeRequests().anyRequest().permitAll();
    }
}