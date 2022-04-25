package com.example.car_repair_shop.security;


import com.example.car_repair_shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
                .antMatchers("/customers/**").hasRole("ADMIN")
                .antMatchers("/cars/**").authenticated()
                .antMatchers("/services/**").permitAll()
                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .antMatchers("/auth/**").permitAll()
                .and()
                .formLogin()
                .and()
                .logout()
                .and()
                .httpBasic();

    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("$2a$05$RuyZmu0mDcQiszbwk8PX2ewWgIdwHtaEOmZJ6oSWFdpiEKUym1yyK").roles("ADMIN")
//                .and()
//                .withUser("moderator").password("$2a$05$eiCVmh1wrRD.0Wuh.B7fue94a5TsWUL8alo5zKpTUsg5AoPHjCvjy").roles("MODERATOR")
//                .and()
//                .withUser("customer").password("$2a$05$vhj5GXfBfUNge8eBhAUJjel2oBM5HJI/Nmj5fCRSuUmx7aRM.nGXy").roles("CUSTOMER");
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userService)
                    .passwordEncoder(passwordEncoder);
        }

}
