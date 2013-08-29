package fr.treeptik.locationvoiture.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.locationvoiture.dao.VoitureDAO;
import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Voiture;
import fr.treeptik.locationvoiture.service.VoitureService;
import fr.treeptik.locationvoiture.service.impl.VoitureS‪erviceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/dispatcher-servlet.xml")
public class TestLocationVoiture {

	@Autowired
	private VoitureService voitureService;

	VoitureService voitureServiceM = new VoitureS‪erviceImpl();

	@Test
	public void testFindAllVoitures() throws DAOException {

		Voiture v1 = new Voiture(null, "Toyota", "Yaris", new Date());
		Voiture v2 = new Voiture(null, "Nissan", "mikra", new Date());
		Voiture v3 = new Voiture(null, "Seat", "Cordoba", new Date());

		List<Voiture> listVoiture = new ArrayList<>();
		listVoiture.add(v1);
		listVoiture.add(v2);
		listVoiture.add(v3);

		// je crée un mock basé sur mon DAO
		VoitureDAO voitureDAOMock = EasyMock.createMock(VoitureDAO.class);

		// on peut avoir plusieurs expect
		EasyMock.expect(voitureDAOMock.findAll()).andReturn(listVoiture);

		EasyMock.replay(voitureDAOMock);

		// pas de getter et de setter, on affecte un champ privé
		ReflectionTestUtils.setField(voitureServiceM, "voitureDAO",
				voitureDAOMock);

		// je test
		try {
			List<Voiture> voitures = voitureServiceM.findAll();
			Assert.assertTrue(voitures.size() == 4);

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}

	}

	@Ignore
	@Test
	@Transactional
	@Rollback(false)
	public void testSaveVoiture() {

		try {
			Voiture v = voitureService.save(new Voiture(null, "Toyota",
					"Rav 4", new Date()));
			Assert.assertNotNull(v.getId());
			System.out.println("Marque : " + v.getMarque());
		} catch (ServiceException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

}
