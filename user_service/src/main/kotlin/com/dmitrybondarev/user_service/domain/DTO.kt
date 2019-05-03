package com.dmitrybondarev.user_service.domain

import com.dmitrybondarev.user_service.util.validation.annotation.PasswordMatches
import com.dmitrybondarev.user_service.util.validation.annotation.ValidEmail
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@PasswordMatches
data class UserDto(
		@ValidEmail @NotNull @NotEmpty var email: String? = null,
		@NotNull @NotEmpty var firstName: String? = null,
		@NotNull @NotEmpty var lastName: String? = null,
		@NotNull @NotEmpty var password: String? = null,
		var matchingPassword: String? = null
)
