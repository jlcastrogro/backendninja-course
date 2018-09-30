package com.udemy.controller;

import javax.websocket.server.PathParam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.constants.ViewConstant;
import com.udemy.model.ContactModel;
import com.udemy.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {
	private static final Log LOGGER = LogFactory.getLog(ContactController.class);

	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;

	@GetMapping("")
	public ModelAndView showContacts() {
		ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
		mav.addObject("contacts", contactService.listAllContact());
		return mav;

	}

	@PostMapping("")
	public String addContact(@ModelAttribute(name = "contact") ContactModel contactModel, Model model) {
		LOGGER.info("Method: 'addContact()' -- Params: '" + contactModel + "'");

		if (contactService.addContact(contactModel) != null) {
			model.addAttribute("result", 1);
		} else {
			model.addAttribute("result", 0);
		}

		return "redirect:/contact";
	}

	@GetMapping("/form")
	public String redirectToContactForm(Model model) {
		model.addAttribute("contact", new ContactModel());
		return ViewConstant.CONTACT_FORM;
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/contact";
	}

	@GetMapping("/remove")
	public ModelAndView removeContact(@RequestParam(name="id", required = true) int id) {
		contactService.removeContact(id);
		return showContacts();
	}
}
