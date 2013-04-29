package com.webonise.DAO;

import java.util.List;

import com.webonise.model.Contact;





public interface ContactDAO {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
	public Contact getContact(int id);
	public void updateContact(int id,Contact c);
}
