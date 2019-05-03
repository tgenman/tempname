package com.dmitrybondarev.user_service.config

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.authorization.AuthorityReactiveAuthorizationManager.hasRole
import jdk.nashorn.internal.runtime.GlobalFunctions.anonymous
import org.springframework.security.authorization.AuthenticatedReactiveAuthorizationManager.authenticated
import org.springframework.security.config.annotation.web.builders.HttpSecurity





@Configuration
@EnableWebSecurity
class SecurityConfig(
		@Qualifier("myUserDetailsService") private val userDetailsService: UserDetailsService
) : WebSecurityConfigurerAdapter() {

	@Throws(Exception::class)
	override fun configure(auth: AuthenticationManagerBuilder?) {
		auth!!.userDetailsService(userDetailsService)
	}

//	@Throws(Exception::class)
//	override fun configure(auth: AuthenticationManagerBuilder?) {
//		auth!!.inMemoryAuthentication()
//				.withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
//				.and()
//				.withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
//				.and()
//				.withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN")
//	}

	@Throws(Exception::class)
	override fun configure(http: HttpSecurity) {
		http
				.csrf().disable()
				.authorizeRequests()
					.antMatchers("/","/login*", "/user/registration", "successRegister").permitAll()
					.antMatchers("/admin/**").hasRole("ADMIN")
					.anyRequest().authenticated()
				.and()
					.formLogin()
					.loginPage("/login")
					.defaultSuccessUrl("/",true)
					.permitAll()
				.and()
					.logout()
					.permitAll()
	}
}
