package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.component.ContactConverter;
import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import com.udemy.repository.ContactRepository;
import com.udemy.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactRepository.save(contactConverter.contactModel2Contact(contactModel));
		return contactConverter.contact2ContactModel(contact);
	}

	@Override
	public List<ContactModel> listAllContact() {
		List<Contact> contactsEntity = contactRepository.findAll();
		List<ContactModel> contactsModel = new ArrayList<>();
		for (Contact contact : contactsEntity) {
			contactsModel.add(contactConverter.contact2ContactModel(contact));
		}
		return contactsModel;
	}

	@Override
	public Contact findContactById(int id) {
		return contactRepository.findById(id);
	}

	@Override
	public void removeContact(int id) {
		Contact contact = contactRepository.findById(id);
		if (contact != null) {
			contactRepository.delete(contact);
		}
	}
	
}
