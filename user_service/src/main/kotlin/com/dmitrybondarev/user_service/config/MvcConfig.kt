package com.dmitrybondarev.user_service.config

import com.dmitrybondarev.user_service.util.validation.EmailValidator
import com.dmitrybondarev.user_service.util.validation.PasswordMatchesValidator
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.i18n.CookieLocaleResolver
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor
import java.util.*

@Configuration
class MvcConfig : WebMvcConfigurer {

	override fun addViewControllers(registry: ViewControllerRegistry) {
		registry.addViewController("/login").setViewName("login")
	}

	override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
		registry.addResourceHandler("/img/**")
				.addResourceLocations("file://")
		registry.addResourceHandler("/static/**")
				.addResourceLocations("classpath:/static/")
	}


	// ============== VALIDATION ============

	@Bean
	fun emailValidator(): EmailValidator {
		return EmailValidator()
	}

	@Bean
	fun passwordMatchesValidator(): PasswordMatchesValidator {
		return PasswordMatchesValidator()
	}

	// ============== LOCALIZATION ============

	override fun addInterceptors(registry: InterceptorRegistry) {
		val localeChangeInterceptor = LocaleChangeInterceptor()
		localeChangeInterceptor.paramName = "lang"
		registry.addInterceptor(localeChangeInterceptor)
	}

	@Bean
	fun localeResolver(): LocaleResolver {
		val cookieLocaleResolver = CookieLocaleResolver()
		cookieLocaleResolver.setDefaultLocale(Locale.US)
		return cookieLocaleResolver
	}

	@Bean
	fun messageSource(): MessageSource {
		val messageSource = ReloadableResourceBundleMessageSource()
		messageSource.setBasename("classpath:messages")
		messageSource.setUseCodeAsDefaultMessage(true)
		messageSource.setDefaultEncoding("UTF-8")
		messageSource.setCacheSeconds(0)
		return messageSource
	}
}