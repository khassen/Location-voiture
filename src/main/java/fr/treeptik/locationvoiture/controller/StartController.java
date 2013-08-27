package fr.treeptik.locationvoiture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StartController {
	
	

	@RequestMapping(value ="/hello.do", method = RequestMethod.GET)
	public ModelAndView securityLogin() {

		return new ModelAndView("login");

	}
	
	@RequestMapping(value ="/begin.do", method = RequestMethod.GET)
	public ModelAndView sommaire() {

		return new ModelAndView("sommaire");

	}
	
	@RequestMapping(value ="/deconnexion.do", method = RequestMethod.GET)
	public ModelAndView logout() {

		return new ModelAndView("long");

	}

}
