package fr.treeptik.locationvoiture.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "/reservation.do", method = RequestMethod.GET)
	public ModelAndView initForm() throws ServiceException {
		Reservation reservation = new Reservation();

		Map<Integer, Object> listClients = new HashMap<Integer, Object>();
		for (Client cli : clientService.findAll()) {

			listClients.put(cli.getId(), cli);

		}

		Map<Integer, Object> listVoitures = new HashMap<Integer, Object>();
		for (Voiture v : voitureService.findAll()) {

			listVoitures.put(v.getId(), v);

		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("reservation", reservation);
		params.put("client", listClients);
		params.put("voiture", listVoitures);

		return new ModelAndView("save-reservation", "reservation", params);

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

	// @RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	// public ModelAndView delete(@RequestParam("id") Integer id)
	// throws ServiceException {
	//
	// clientService.remove(id);
	//
	// return new ModelAndView("delete-client");
	//
	// }
	//
	// @RequestMapping(value = "/update.do", method = RequestMethod.POST)
	// public ModelAndView updateClient(Client cli) throws ServiceException {
	//
	// clientService.update(cli);
	//
	// return new ModelAndView("redirect:clients.do");
	//
	// }
	//
	// @RequestMapping(value = "update.do", method = RequestMethod.GET)
	// public ModelAndView initUpdateClient(Client cli) throws ServiceException
	// {
	//
	// cli = clientService.findById(cli.getId());
	//
	// return new ModelAndView("update-client", "client", cli);
	//
	// }

}
