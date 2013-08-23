package fr.treeptik.locationvoiture.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Client;
import fr.treeptik.locationvoiture.model.Reservation;
import fr.treeptik.locationvoiture.model.Voiture;
import fr.treeptik.locationvoiture.service.ClientService;
import fr.treeptik.locationvoiture.service.ReservationService;
import fr.treeptik.locationvoiture.service.VoitureService;

@Controller
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private VoitureService voitureService;

	// @RequestMapping(value = "/reservation.do", method = RequestMethod.GET)
	// public ModelAndView initForm(Reservation reservation) throws
	// ServiceException {
	//
	//
	// Map<Integer, Object> listClients = new HashMap<Integer, Object>();
	// for (Client cli : clientService.findAll()) {
	//
	// listClients.put(cli.getId(), cli);
	//
	// }
	//
	// Map<Integer, String> listVoitures = new HashMap<Integer, String>();
	// for (Voiture v : voitureService.findAll()) {
	//
	// listVoitures.put(v.getId(), v.toString());
	//
	// }
	//
	// Map<String, Object> params = new HashMap<String, Object>();
	// params.put("reservation", reservation);
	// params.put("listClients", listClients);
	// params.put("listVoitures", listVoitures);
	//
	// return new ModelAndView("save-reservation", params);
	//
	// }

	@RequestMapping(value = "/reservation.do", method = RequestMethod.GET)
	public ModelAndView initForm(Reservation reservation)
			throws ServiceException {
		List<Client> listClients = clientService.findAll();
		List<Voiture> listVoitures = voitureService.findAll();

		ModelAndView modelAndView = new ModelAndView("save-reservation",
				"reservation", reservation);

		modelAndView.addObject("clients", listClients);
		modelAndView.addObject("voitures", listVoitures);

		return modelAndView;

	}

	@RequestMapping(value = "/reservation.do", method = RequestMethod.POST)
	public ModelAndView save(Reservation reservation) throws ServiceException {

		reservationService.save(reservation);

		return new ModelAndView("redirect:reservations.do");

	}

	@RequestMapping(value = "/reservations.do", method = RequestMethod.GET)
	public ModelAndView findAll() throws ServiceException {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("listReservations", reservationService.findAll());

		return new ModelAndView("list-reservation", params);

	}

	@RequestMapping(value = "/delete-reservation.do", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") Integer id)
			throws ServiceException {
		reservationService.remove(id);

		return new ModelAndView("delete-reservation");

	}
	
	
	@RequestMapping(value = "/update-reservation.do", method = RequestMethod.GET)
	public ModelAndView initUpdateReservation(Reservation reservation)
			throws ServiceException {

		reservation = reservationService.findById(reservation.getId());

		ModelAndView modelAndView = new ModelAndView("update-reservation",
				"reservation", reservation);

		List<Client> listClients = clientService.findAll();
		List<Voiture> listVoitures = voitureService.findAll();

		modelAndView.addObject("clients", listClients);
		modelAndView.addObject("voitures", listVoitures);

		return modelAndView;

	}

	@RequestMapping(value = "/update-reservation.do", method = RequestMethod.POST)
	public ModelAndView updateReservation(Reservation reservation) throws ServiceException {

		reservationService.update(reservation);

		return new ModelAndView("redirect:reservations.do");

	}



}
