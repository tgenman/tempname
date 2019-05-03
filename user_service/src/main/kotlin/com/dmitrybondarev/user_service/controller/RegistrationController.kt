package com.dmitrybondarev.user_service.controller

import com.dmitrybondarev.user_service.domain.User
import com.dmitrybondarev.user_service.domain.UserDto
import com.dmitrybondarev.user_service.service.api.IUserService
import com.dmitrybondarev.user_service.util.EmailExistsException
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.context.request.WebRequest
import javax.validation.Valid

const val GO_TO_REGISTRATION_PAGE = "registration"
const val USER_DTO = "userDto"


@Controller
class RegistrationController(private val iUserService: IUserService) {

	@GetMapping("/user/registration")
	fun showRegistrationForm(request: WebRequest, model: Model): String {
		model.addAttribute("userDto", UserDto())
		return GO_TO_REGISTRATION_PAGE
	}

	@PostMapping("/user/registration")
	fun registerUserAccount(
			@ModelAttribute("user") @Valid userDto: UserDto,
			bindingResult: BindingResult,
			request: WebRequest,
			model: Model,
			errors: Errors
	): String {

		if (bindingResult.hasErrors()) {
			model.addAttribute(USER_DTO, userDto)
			return GO_TO_REGISTRATION_PAGE
		}

		val registered: User = try {
			iUserService.registerNewUserAccount(userDto)
		} catch (e: EmailExistsException) {
			bindingResult.rejectValue("email", "message.regError")
			model.addAttribute(USER_DTO, userDto)
			return GO_TO_REGISTRATION_PAGE
		}

		return "successRegister"
	}


//		var registered: User? = User()
//
//		if (!bindingResult.hasErrors()) {
//			registered = createUserAccount(accountDto, bindingResult)
//		}
//		if (registered == null) {
//			bindingResult.rejectValue("email", "message.regError")
//		}
//
//		return if (bindingResult.hasErrors()) {
//			ModelAndView("registration", "user", accountDto)
//		} else {
//			ModelAndView("successRegister", "user", accountDto)
//		}

}