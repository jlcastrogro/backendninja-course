package com.udemy.component;

import org.springframework.stereotype.Component;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;

@Component
public class ContactConverter {
	public Contact contactModel2Contact(ContactModel contactModel) {
		Contact contact = new Contact();
		contact.setId(contactModel.getId());
		contact.setFirstname(contactModel.getFirstname());
		contact.setLastname(contactModel.getLastname());
		contact.setTelephone(contactModel.getTelephone());
		contact.setCity(contactModel.getCity());

		return contact;
	}

	public ContactModel contact2ContactModel(Contact contact) {
		ContactModel contactModel = new ContactModel();
		contactModel.setId(contact.getId());
		contactModel.setFirstname(contact.getFirstname());
		contactModel.setLastname(contact.getLastname());
		contactModel.setTelephone(contact.getTelephone());
		contactModel.setCity(contact.getCity());

		return contactModel;
	}
}
