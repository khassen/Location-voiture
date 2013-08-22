package fr.treeptik.locationvoiture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.locationvoiture.dao.ReservationDAO;
import fr.treeptik.locationvoiture.model.Reservation;

@Service
public class ReservationServiceImpl extends GenericServiceImpl<Reservation, Integer, ReservationDAO> {

	@Autowired
	private ReservationDAO reservationDAO;
	
	
	@Override
	protected ReservationDAO getDAO() {
		return reservationDAO;
	}

}
