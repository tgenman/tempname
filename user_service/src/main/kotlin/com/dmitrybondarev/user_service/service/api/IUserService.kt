package com.dmitrybondarev.user_service.service.api

import com.dmitrybondarev.user_service.domain.User
import com.dmitrybondarev.user_service.domain.UserDto


interface IUserService {

	fun registerNewUserAccount(userDto: UserDto): User
}