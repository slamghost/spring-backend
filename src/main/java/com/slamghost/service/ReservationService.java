package com.slamghost.service;

import java.util.List;

import com.slamghost.model.Reservation;

public interface ReservationService {
	
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
