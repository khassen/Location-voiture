package fr.treeptik.locationvoiture.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.treeptik.locationvoiture.model.Reservation;

@Component
public class ReservationValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return arg0.getClass().equals(Reservation.class);
	}

	@Override
	public void validate(Object reservation, Errors errors) {

		Reservation reser = (Reservation) reservation;

		if (reser.getdateResev().after(reser.getDatePrise())) {
			errors.reject("dateReservation",
					"save-reservation.dateResev.afterdatePrise");
		}

		if (reser.getdateResev().after(reser.getDateRetour())) {
			errors.rejectValue("dateReservation",
					"save-reservation.dateReser.afterdateRetour");
		}

		if (reser.getDatePrise().after(reser.getDateRetour())) {
			errors.rejectValue("dateRetour",
					"save.reservation.datePrise.afterdateRetour");
		}

	}

}
