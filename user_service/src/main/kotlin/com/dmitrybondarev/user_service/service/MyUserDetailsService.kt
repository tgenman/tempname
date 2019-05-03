package com.dmitrybondarev.user_service.service

import com.dmitrybondarev.user_service.repository.UserRepository
import com.dmitrybondarev.user_service.util.UserNotFoundException
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class MyUserDetailsService(private val userRepository: UserRepository) : UserDetailsService {

	@Throws(UserNotFoundException::class)
	override fun loadUserByUsername(email: String): UserDetails {

		val user = userRepository.findByEmail(email) ?: throw UserNotFoundException("No user found with username: $email")

		val enabled = true
		val accountNonExpired = true
		val credentialsNonExpired = true
		val accountNonLocked = true

		return org.springframework.security.core.userdetails.User(
				user.email,
				user.password.toLowerCase(),
				enabled,
				accountNonExpired,
				credentialsNonExpired,
				accountNonLocked,
				getAuthorities(user.roles))
	}

	private fun getAuthorities(roles: List<String>): List<GrantedAuthority> {
		val authorities = ArrayList<GrantedAuthority>()
		for (role in roles) {
			authorities.add(SimpleGrantedAuthority(role))
		}
		return authorities
	}
}