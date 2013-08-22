package fr.treeptik.locationvoiture.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="client")
public class Client {
	
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nom;
	
	private String prenom;
	
	private String email;
	


	@OneToMany(mappedBy="client")
	private List<Reservation> listReservations;
	
	public Client() {
		super();
	}

	public Client(Integer id, String nom, String prenom, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Reservation> getListReservations() {
		return listReservations;
	}

	public void setListReservations(List<Reservation> listReservations) {
		this.listReservations = listReservations;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
