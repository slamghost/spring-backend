package com.slamghost.dao;

import java.util.List;
import com.slamghost.model.Contact;

public interface ContactDAO {

	public long save(Contact contact);

	public Contact get(long id);

	public List<Contact> list();

	public void update(long id, Contact contact);

	public void delete(long id);
	
	public Contact getByName(String name);
}
