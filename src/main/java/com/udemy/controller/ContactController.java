package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.constants.ViewConstant;

@Controller
@RequestMapping("/contact")
public class ContactController {
	@GetMapping("/form")
	public String redirectForm() {
		return ViewConstant.CONTACT_FORM;
	}
}
