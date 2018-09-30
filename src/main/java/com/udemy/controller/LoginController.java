package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.model.UserCredential;

@Controller
public class LoginController {

	private static final Log LOGGER = LogFactory.getLog(LoginController.class);

	@GetMapping("/")
	public String redirectToLogin() {
		LOGGER.info("Method: 'redirectToLogin()'");
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		LOGGER.info("Method: 'showLoginForm()' -- Params: 'error'='" + error + "', 'logout'='" + logout + "'");
		model.addAttribute("userCredential", new UserCredential());
		model.addAttribute("logout", logout);
		model.addAttribute("error", error);
		LOGGER.info("Returning login view");
		return "login";
	}

	@PostMapping("/login")
	public String loginCheck(@ModelAttribute(name = "UserCredential") UserCredential userCredential) {
		LOGGER.info("Method: 'loginCheck()' -- Params: '" + userCredential + "'");
		if (userCredential.getPassword().equals("user") && userCredential.getPassword().equals("user")) {
			LOGGER.info("Returning contacts view");
			return "contacts";
		} else {
			LOGGER.info("Redirecting to login view with errors");
			return "redirect:/login?error";
		}
	}
}
