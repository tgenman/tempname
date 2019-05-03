package com.dmitrybondarev.user_service.util.validation.annotation

import com.dmitrybondarev.user_service.util.validation.EmailValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [EmailValidator::class])
@MustBeDocumented
annotation class ValidEmail(
		val message: String = "Invalid Email",
		val groups: Array<KClass<*>> = [],
		val payload: Array<KClass<out Payload>> = []
)