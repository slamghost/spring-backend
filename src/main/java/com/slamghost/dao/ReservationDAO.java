package com.slamghost.dao;

import java.util.List;

import com.slamghost.model.Reservation;

public interface ReservationDAO {

	// Save the record	
	long save(Reservation reservation);
	
	// Get reservation
	Reservation get(long id);
	
	// Reservation list	
	List<Reservation> list();
	
	
	// Update a reservation	
	int update(long id, Reservation reservation);
	
	
	// Delete a reservation	
	int delete(long id);
	
}
