package com.example.asm2.Config;

import com.example.asm2.Filter.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpRequest;
@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class Config {
    @Autowired
    ConfigToken cf;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(request ->
                request.requestMatchers("/admin/**").hasAuthority("SCOPE_CV01")
                        .anyRequest().permitAll()
        );
        httpSecurity.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());
        httpSecurity.oauth2ResourceServer(request -> request.jwt(
                jwtConfigurer -> jwtConfigurer.decoder(cf)
        ));
        return httpSecurity.build();
    }
    @Bean
    public FilterRegistrationBean<Filter> loggingFilter() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new Filter());
        registrationBean.addUrlPatterns("/api/*"); // Áp dụng filter cho URL pattern cụ thể
        return registrationBean;
    }
}
