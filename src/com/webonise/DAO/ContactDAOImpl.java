package com.webonise.DAO;

import java.util.List;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webonise.model.Contact;


@Repository
public class ContactDAOImpl implements ContactDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addContact(Contact contact) {
		sessionFactory.getCurrentSession().save(contact);
	}

	public List<Contact> listContact() {

		return sessionFactory.getCurrentSession().createQuery("from Contact").list();
	}

	public void removeContact(Integer id) {
		Contact contact = (Contact) sessionFactory.getCurrentSession().load(
				Contact.class, id);
		if (null != contact) {
			sessionFactory.getCurrentSession().delete(contact);
		}

	}

	public Contact getContact(int id) {
		// TODO Auto-generated method stub
		Contact contact = (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
		return contact;
	}
	
	public void updateContact(int id,Contact contact)
	{
		Contact contactToEdit = getContact(id);
		contactToEdit.setFirstname(contact.getFirstname());
		contactToEdit.setLastname(contact.getLastname());
		contactToEdit.setEmail(contact.getEmail());
		contactToEdit.setTelephone(contact.getTelephone());
		sessionFactory.getCurrentSession().update(contactToEdit);
	}
}
