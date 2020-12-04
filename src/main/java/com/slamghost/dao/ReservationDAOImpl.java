package com.slamghost.dao;

import java.util.List;

import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.slamghost.model.Reservation;
import com.slamghost.service.ContactService;

@Repository
public class ReservationDAOImpl implements ReservationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ContactService contactService;

	@Override
	@Transactional
	public long save(Reservation reservation) {

		sessionFactory.getCurrentSession().save(reservation);

		return reservation.getId();
	}

	@Override
	public Reservation get(long id) {

		return sessionFactory.getCurrentSession().get(Reservation.class, id);
	}

	@Override
	public List<Reservation> list() {

		@SuppressWarnings("unchecked")
		List<Reservation> list = sessionFactory.getCurrentSession()
				.createQuery("from reservation r order by r.description asc").list();

		return list;
	}

	@Override
	public int update(long id, Reservation reservation) {

		try {
			Session session = sessionFactory.getCurrentSession();

			Reservation oldReservation = session.byId(Reservation.class).load(id);

			// oldReservation.setOwner(reservation.getOwner());
			oldReservation.setDescription(reservation.getDescription());
			contactService.update(reservation.getOwner().getId(), reservation.getOwner());

			session.flush();

			return 1;

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0; 

	}

	@Override
	public int delete(long id) {

		if (id > 0) {

			Session session = sessionFactory.getCurrentSession();
			Reservation reservation = session.byId(Reservation.class).load(id);

			if (reservation != null) {
				session.delete(reservation);
				return 1;
			}

			return 0;
		}
		return 0;
	}

}
