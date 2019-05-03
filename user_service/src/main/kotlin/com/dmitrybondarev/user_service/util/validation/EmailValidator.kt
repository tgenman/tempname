package com.dmitrybondarev.user_service.util.validation


import com.dmitrybondarev.user_service.util.validation.annotation.ValidEmail
import java.util.regex.Matcher
import java.util.regex.Pattern

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class EmailValidator : ConstraintValidator<ValidEmail, String> {
	private var pattern: Pattern? = null
	private var matcher: Matcher? = null

	override fun initialize(constraintAnnotation: ValidEmail?) {}

	override fun isValid(username: String, context: ConstraintValidatorContext): Boolean {
		return validateEmail(username)
	}

	private fun validateEmail(email: String): Boolean {
		pattern = Pattern.compile(EMAIL_PATTERN)
		matcher = pattern!!.matcher(email)
		return matcher!!.matches()
	}

	companion object {
		private val EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
	}
}
