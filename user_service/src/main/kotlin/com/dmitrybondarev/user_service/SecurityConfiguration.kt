package com.dmitrybondarev.user_service

import org.springframework.context.annotation.Configuration
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

//
//@Configuration
//@EnableWebSecurity
//class SecurityConfiguration : WebSecurityConfigurerAdapter() {
//
//    @Throws(Exception::class)
//    override fun configure(auth: AuthenticationManagerBuilder?) {
//        auth!!
//                .inMemoryAuthentication()
//                .withUser("user")
//                .password("password")
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password("admin")
//                .roles("USER", "ADMIN")
//    }
//
//    @Throws(Exception::class)
//    override fun configure(http: HttpSecurity) {
//        http
//                .authorizeRequests()
//                    .antMatchers("/hui").permitAll()
//                    .antMatchers("/").permitAll()
////                    .anyRequest().authenticated()
//                .and()
//                .httpBasic()
//    }
//}