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
import fr.treeptik.locationvoiture.model.Voiture;
import fr.treeptik.locationvoiture.service.ClientService;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	
	@RequestMapping(value = "/client.do", method = RequestMethod.GET)
	public ModelAndView initForm() throws ServiceException {
		Client cli = new Client();
		ModelAndView modelAndView = new ModelAndView("save-client",
				"client", cli);
		return modelAndView;
	}

	@RequestMapping(value="/client.do", method=RequestMethod.POST)
	public ModelAndView save(Client client) throws ServiceException{
		
		clientService.save(client);
		
		return new ModelAndView("redirect=:clients.do");
		
	}
	

	@RequestMapping(value="/clients.do", method=RequestMethod.GET)
	public ModelAndView findAll() throws ServiceException{
		
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("listClients", clientService.findAll());
		
		
		return new ModelAndView("list-client",params);
		
	}
}
