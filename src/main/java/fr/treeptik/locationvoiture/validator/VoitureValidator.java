package fr.treeptik.locationvoiture.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.treeptik.locationvoiture.model.Voiture;



@Component
public class VoitureValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		//permet de valider des voiture
		return arg0.getClass().equals(Voiture.class);
	}

	
	//on va modifier l'objet erreur qui est en parametre
	@Override
	public void validate(Object voiture, Errors errors) {
		// je transforme mon objet voiture
     Voiture v = (Voiture) voiture;
		if(v.getMarque().equalsIgnoreCase(v.getModel())){
			errors.rejectValue("model","saisie-voiture.model.equalsmarque");
		}
	}

}
