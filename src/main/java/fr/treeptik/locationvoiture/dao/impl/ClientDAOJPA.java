package fr.treeptik.locationvoiture.dao.impl;

import fr.treeptik.locationvoiture.dao.ClientDAO;
import fr.treeptik.locationvoiture.model.Client;

public class ClientDAOJPA extends GenericDAOJPA<Client, Integer> implements ClientDAO{

	public ClientDAOJPA() {
		super(Client.class);
	}

}
