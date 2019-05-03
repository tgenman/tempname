package com.dmitrybondarev.user_service.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

	@GetMapping("/")
	fun showHomePage(): String {
		return "index"
	}


}