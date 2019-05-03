package com.dmitrybondarev.user_service.util.validation.annotation

import com.dmitrybondarev.user_service.util.validation.PasswordMatchesValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [PasswordMatchesValidator::class])
@MustBeDocumented
annotation class PasswordMatches(
		val message: String = "Passwords don't match",
		val groups: Array<KClass<*>> = [],
		val payload: Array<KClass<out Payload>> = []
)