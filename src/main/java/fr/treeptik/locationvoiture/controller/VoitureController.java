package fr.treeptik.locationvoiture.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Voiture;
import fr.treeptik.locationvoiture.service.VoitureService;
import fr.treeptik.locationvoiture.validator.VoitureValidator;

@Controller
//@RequestMapping(value="/voiture")
public class VoitureController {

	@Autowired
	private VoitureService voitureService;

	@Autowired
	private VoitureValidator validator;


	@RequestMapping(value = "/voiture.do", method = RequestMethod.GET)
	public ModelAndView initForm() throws ServiceException {
		Voiture v = new Voiture();
		ModelAndView modelAndView = new ModelAndView("saisie-voiture",
				"voiture", v);
		return modelAndView;
	}

	@RequestMapping(value = "/voiture.do", method = RequestMethod.POST)
	public ModelAndView saisieVoiture(@Valid Voiture voiture,
			BindingResult errors) throws ServiceException {

		// ca permet de valider d'autre saisie autre que celle valider par
		// hibernate valdator

		validator.validate(voiture, errors);

		if (errors.hasErrors()) {
			return new ModelAndView("saisie-voiture", "voiture", voiture);
		}

		voitureService.save(voiture);
		System.out.println("Voiture marque: " + voiture.getMarque());
		return new ModelAndView("redirect:voitures.do");

	}

	// @RequestMapping(value = "/voiture.do", method = RequestMethod.POST)
	// public ModelAndView saisieDeVoiture( Voiture voiture) throws
	// ServiceException {
	//
	//
	//
	// voitureService.save(voiture);
	// Map<String, Object> params = new HashMap<String, Object>();
	// params.put("listVoitures", voitureService.findAll());
	// return new ModelAndView("list-voiture",params);
	//
	// }

	@RequestMapping(value = "/voitures.do", method = RequestMethod.GET)
	public ModelAndView findAllVoiture() throws ServiceException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("listVoitures", voitureService.findAll());
		params.put("supervoiture", new Voiture(6, "SUPER VOITURE",
				"SUPER VOITURE"));

		return new ModelAndView("list-voiture", params);
	}

	@RequestMapping(value = "/supprimer.do", method = RequestMethod.GET)
	public ModelAndView supprimerVoiture(@RequestParam("id") Integer id)
			throws ServiceException {

		voitureService.remove(id);

		return new ModelAndView("supprimer-voiture");

	}

	@RequestMapping(value = "/modifier.do", method = RequestMethod.POST)
	public ModelAndView modifierVoiture(Voiture v) throws ServiceException {

		voitureService.update(v);

		return new ModelAndView("redirect:voitures.do");

	}

	@RequestMapping(value = "modifier.do", method = RequestMethod.GET)
	public ModelAndView initModifier(Voiture voiture) throws ServiceException {

		voiture = voitureService.findById(voiture.getId());

		return new ModelAndView("modifier-voiture", "voiture", voiture);

	}
}
