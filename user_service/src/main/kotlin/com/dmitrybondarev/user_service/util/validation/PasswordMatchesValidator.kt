package com.dmitrybondarev.user_service.util.validation

import com.dmitrybondarev.user_service.domain.UserDto
import com.dmitrybondarev.user_service.util.validation.annotation.PasswordMatches
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class PasswordMatchesValidator : ConstraintValidator<PasswordMatches, Any> {

	override fun initialize(constraintAnnotation: PasswordMatches?) {
		//
	}

	override fun isValid(obj: Any, context: ConstraintValidatorContext): Boolean {
		val user = obj as UserDto
		return user.password.equals(user.matchingPassword)
	}

}