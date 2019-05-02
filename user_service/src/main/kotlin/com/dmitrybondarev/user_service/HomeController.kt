package com.dmitrybondarev.user_service

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

	@GetMapping("/")
	fun getHomePage(model: Model): String {
		model["title"] = "Blog"
		return "blog"
	}

}