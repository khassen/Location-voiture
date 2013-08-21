package fr.treeptik.locationvoiture.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Voiture;
import fr.treeptik.locationvoiture.service.VoitureService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/dispatcher-servlet.xml")
public class TestLocationVoiture {
	
	@Autowired
	private VoitureService voitureService;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testSaveVoiture(){
		
		
		try {
		Voiture v =	voitureService.save(new Voiture(null,"Toyota", "Rav 4"));
			Assert.assertNotNull(v.getId());
			System.out.println("Marque : "+v.getMarque());
			} catch (ServiceException e) {
				e.printStackTrace();
				Assert.fail(e.getMessage());
			}
	}

}
