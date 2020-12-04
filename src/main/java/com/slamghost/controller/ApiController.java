package com.slamghost.controller;

import java.util.List;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.slamghost.model.Contact;
import com.slamghost.model.Reservation;
import com.slamghost.service.ContactService;
import com.slamghost.service.ReservationService;

@RestController
@CrossOrigin("*")
public class ApiController {

	@Autowired
	private ReservationService resService;

	@Autowired
	private ContactService contactService;

	// Get all reservations
	@GetMapping("/api/reservation")
	public ResponseEntity<List<Reservation>> list() {

		List<Reservation> list = resService.list();
		return ResponseEntity.ok().body(list);
	}

	// Save the Reservation
	@PostMapping("/api/save")
	public ResponseEntity<?> save(@RequestBody Reservation reservation) {

		long id = resService.save(reservation);

		return ResponseEntity.ok().body(id);

	}

	// Get a reservation
	@GetMapping("/api/get/{id}")
	public ResponseEntity<Reservation> get(@PathVariable("id") long id) {

		Reservation reservation = resService.get(id);

		if (reservation.getId() > 0)
			return ResponseEntity.ok().body(reservation);

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// Update a reservation
	@PutMapping("/api/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Reservation reservation) {

		int response = resService.update(id, reservation);

		if (response == 1)
			return new ResponseEntity<>(response, HttpStatus.OK);

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// Delete a reservation
	@DeleteMapping("/api/delete/{id}")
	public ResponseEntity<Long> delete(@PathVariable("id") long id) {

		long response = resService.delete(id);
		if (response == 1)
			return new ResponseEntity<>(response, HttpStatus.OK);

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@GetMapping("/api/get_contact/{name}")
	public ResponseEntity<Contact> getContactByName(@PathVariable("name") String name) {

		Contact c = contactService.getByName(name);

		if (c != null && c.getId() > 0)
			return ResponseEntity.ok().body(c);

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
