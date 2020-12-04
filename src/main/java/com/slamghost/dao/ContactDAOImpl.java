package com.slamghost.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.slamghost.model.Contact;

@Repository
public class ContactDAOImpl implements ContactDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Contact contact) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Contact get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Contact> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void update(long id, Contact contact) {

		Session session = sessionFactory.getCurrentSession();

		Contact old = session.byId(Contact.class).load(id);

		old.setBirthdate(contact.getBirthdate());
		old.setName(contact.getName());
		old.setPhone(contact.getPhone());
		old.setType(contact.getType());

		session.flush();
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public Contact getByName(String name) {

		try {

			Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL getContactByName(:param)")
					.addEntity(Contact.class).setParameter("param", name);

			Contact contact = (Contact) query.getSingleResult();

			return contact;
			
		} catch (NoResultException e) {

		   return null;
		}
		 
	}

}
