package com.slamghost.service;

import java.util.List;

import com.slamghost.model.Contact; 

public interface ContactService {

	
	// Save the record	
	long save(Contact c);
	
	// Get contact
	Contact get(long id);
	
	// Contact list	
	List<Contact> list();
	
	
	// Update a contact	
	void update(long id, Contact c);
	
	
	// Delete a contact	
	int delete(long id);
	
	
	// Get a contact	
	public Contact getByName(String name);
}
