package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.model.UserCredential;

@Controller
public class LoginController {

	@GetMapping("/")
	public String redirectToLogin() {
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		model.addAttribute("userCredential", new UserCredential());
		model.addAttribute("logout", logout);
		model.addAttribute("error", error);
		return "login";
	}

	@PostMapping("/login")
	public String loginCheck(@ModelAttribute(name = "UserCredential") UserCredential userCredential) {
		if (userCredential.getPassword().equals("user") && userCredential.getPassword().equals("user")) {
			return "contacts";
		} else {
			return "redirect:/login?error";
		}
	}
}
