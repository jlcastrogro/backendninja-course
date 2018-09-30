package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.constants.ViewConstant;
import com.udemy.model.ContactModel;

@Controller
@RequestMapping("/contact")
public class ContactController {
	private static final Log LOGGER = LogFactory.getLog(ContactController.class);

	@GetMapping("")
	public String showContact() {
		return ViewConstant.CONTACTS;
	}

	@GetMapping("/cancel")
	public String cancel() {
		return ViewConstant.CONTACTS;
	}

	@GetMapping("/form")
	public String redirectToContactForm(Model model) {
		model.addAttribute("contact", new ContactModel());
		return ViewConstant.CONTACT_FORM;
	}

	@PostMapping("")
	public String addContact(@ModelAttribute(name = "contact") ContactModel contactModel, Model model) {
		LOGGER.info("Method: 'addContact()' -- Params: '" + contactModel + "'");
		model.addAttribute("result", 1);
		return ViewConstant.CONTACTS;
	}
}
