package com.dmitrybondarev.user_service.service

import com.dmitrybondarev.user_service.domain.User
import com.dmitrybondarev.user_service.domain.UserDto
import com.dmitrybondarev.user_service.repository.UserRepository
import com.dmitrybondarev.user_service.service.api.IUserService
import org.springframework.stereotype.Service
import javax.transaction.Transactional
import com.dmitrybondarev.user_service.util.EmailExistsException
import java.util.*


@Service
open class UserService(private val userRepository: UserRepository) : IUserService {

	@Transactional
	@Throws(EmailExistsException::class)
	override fun registerNewUserAccount(userDto: UserDto): User {

//		if (emailExists(userDto.email!!)) {
//			throw EmailExistsException("There is an account with that email address: ${userDto.email}")
//		}

		userRepository.findByEmail(userDto.email!!) ?: throw EmailExistsException("There is an account with that email address: ${userDto.email}")

		var newUser = User()
		newUser.firstName = userDto.firstName!!
		newUser.lastName = userDto.lastName!!
		newUser.password = userDto.password!!
		newUser.email = userDto.email!!
		newUser.roles = Arrays.asList("ROLE_USER")
		return userRepository.save(newUser)
	}

//	private fun emailExists(email: String): Boolean {
//		val user = userRepository.findByEmail(email)
//		return if (user != null) {
//			true
//		} else false
//	}

}
