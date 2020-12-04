package com.slamghost.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slamghost.dao.ReservationDAO;
import com.slamghost.model.Reservation;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private ReservationDAO reservationDAO;
	
	@Override
	public long save(Reservation reservation) {
		
		return reservationDAO.save(reservation);
	}

	@Override
	@Transactional
	public Reservation get(long id) {
		
		return reservationDAO.get(id);
	}

	@Override
	@Transactional
	public List<Reservation> list() {
		
		return reservationDAO.list();
	}

	@Override
	@Transactional
	public int update(long id, Reservation reservation) {
	 
		return reservationDAO.update(id, reservation);
	}

	@Override
	@Transactional
	public int delete(long id) {
	 
	 int response = reservationDAO.delete(id);
	 	
	 return response;
		
	}

	
	
}
