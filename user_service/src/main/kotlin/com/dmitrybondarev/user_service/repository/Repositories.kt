package com.dmitrybondarev.user_service.repository

import com.dmitrybondarev.user_service.domain.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {

	fun findByEmail(email: String): User?
}