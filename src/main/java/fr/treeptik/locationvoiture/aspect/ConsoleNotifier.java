package fr.treeptik.locationvoiture.aspect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.springframework.stereotype.Component;

import fr.treeptik.locationvoiture.model.Voiture;

@Component
public class ConsoleNotifier {

	public void afterReturning(StaticPart staticPart, Object result) {

		System.out.println("Point cut : " + staticPart.toString());
		System.out.println("object saved : " + result.getClass().getName());

		// methode generique pour tous les objets

		// -1- generique

		System.out.println(new Date());

		try {
			Method method = result.getClass().getMethod("getId");
			Integer id = (Integer) method.invoke(result);

			System.out.println(result.getClass().getName() + " " + id);

		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		// -2- generique

		Method[] methods = result.getClass().getMethods();
		for (Method method : methods) {
			if (method.getName().startsWith("get")) {

				try {
					System.out.println("++ " + method.getName() + "++" + method.invoke(result));
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}

			}

		}

		// -3- chaque classe toute seule

		// if (result instanceof Voiture) {
		// Voiture v = (Voiture) result;
		//
		// System.out.println("Voiture marque : " + v.getMarque() + "id : "
		// + v.getId());
		// }

	}

	public void beforeSave(JoinPoint joinPoint) {

		System.out.println("Signature  " + joinPoint.getSignature().getName());
		Object[] args = joinPoint.getArgs();
		Voiture v = (Voiture) args[0];
		v.setMarque("Hack Contact");
		System.out.println("Before save nom : " + v.getMarque());

	}

}
