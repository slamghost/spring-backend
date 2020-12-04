package com.slamghost.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slamghost.dao.ContactDAO;
import com.slamghost.model.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO contactDAO;

	@Override
	public long save(Contact c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Contact get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(long id, Contact c) {

		contactDAO.update(id, c);
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Contact getByName(String name) {
		 
		return contactDAO.getByName(name);
	}
	


}
