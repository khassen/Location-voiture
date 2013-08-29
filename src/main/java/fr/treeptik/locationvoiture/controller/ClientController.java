package fr.treeptik.locationvoiture.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Client;
import fr.treeptik.locationvoiture.service.ClientService;

@Controller
@RequestMapping(value="/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	
	
//	mysql> select * from client c 
//	join reservation r on c.id = r.id_client where c.id in(select id_client from reservation);

	
	@RequestMapping(value = "/client.do", method = RequestMethod.GET)
	public ModelAndView initForm() throws ServiceException {
		Client cli = new Client();
		ModelAndView modelAndView = new ModelAndView("client/save-client",
				"client", cli);
		return modelAndView;
	}

	@RequestMapping(value="/client.do", method=RequestMethod.POST)
	public ModelAndView save(Client client) throws ServiceException{
		
		clientService.save(client);
		
		return new ModelAndView("redirect:clients.do");
		
	}
	

	@RequestMapping(value="/clients.do", method=RequestMethod.GET)
	public ModelAndView findAll() throws ServiceException{
		
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("listClients", clientService.findAll());
		
		
		return new ModelAndView("client/list-client",params);
		
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") Integer id)
			throws ServiceException {

		clientService.remove(id);

		return new ModelAndView("client/delete-client");

	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public ModelAndView updateClient(Client cli) throws ServiceException {

		clientService.update(cli);

		return new ModelAndView("redirect:clients.do");

	}
	
	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public ModelAndView initUpdateClient(Client cli) throws ServiceException {

		cli = clientService.findById(cli.getId());

		return new ModelAndView("client/update-client", "client", cli);

	}
}
