package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.constants.ViewConstant;

@Controller
public class LoginController {

	private static final Log LOGGER = LogFactory.getLog(LoginController.class);

	@GetMapping("/login")
	public String showLoginForm(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		LOGGER.info("Method: 'showLoginForm()' -- Params: 'error'='" + error + "', 'logout'='" + logout + "'");
		model.addAttribute("logout", logout);
		model.addAttribute("error", error);
		LOGGER.info("Returning login view");
		return ViewConstant.LOGIN;
	}

	@GetMapping({ "/", "/loginsucess" })
	public String loginCheck() {
		LOGGER.info("Method: 'loginCheck()'");
		LOGGER.info("Returning contacts view");
		return "redirect:/contact";
	}
}
