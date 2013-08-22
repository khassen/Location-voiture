package fr.treeptik.locationvoiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Client;
import fr.treeptik.locationvoiture.service.ClientService;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value="/client.do", method=RequestMethod.POST)
	public ModelAndView save(Client client) throws ServiceException{
		
		clientService.save(client);
		
		return new ModelAndView("redirect=:clients.do");
		
	}
	

}
