package com.webonise.service;

import java.util.List;


import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webonise.DAO.ContactDAO;
import com.webonise.model.Contact;


@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO contactDAO;
	
	@Transactional
	public void addContact(Contact contact) {
		contactDAO.addContact(contact);
	}

	@Transactional
	public List<Contact> listContact() {

		return contactDAO.listContact();
	}

	@Transactional
	public void removeContact(Integer id) {
		contactDAO.removeContact(id);
	}

	@Transactional
	public Contact getContact(int id) {
		return contactDAO.getContact(id);
	}

	@Transactional
	public void updateContact(int id,Contact contact) {
		contactDAO.updateContact(id,contact);
 }
}
