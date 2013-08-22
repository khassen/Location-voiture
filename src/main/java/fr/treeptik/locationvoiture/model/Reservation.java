package fr.treeptik.locationvoiture.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@DateTimeFormat
	private Date dateReservation;
	
	@DateTimeFormat
	private Date datePrise;
	
	@DateTimeFormat
	private Date dateRetour;

	@ManyToOne()
	@JoinColumn(name = "id_client")
	private Client client;

	@OneToOne
	@JoinColumn(name = "id_voiture")
	private Voiture voiture;

	public Reservation() {
		super();
	}

	public Reservation(Integer id, Date dateReservation, Date datePrise,
			Date dateRetour, Client client, Voiture voiture) {
		super();
		this.id = id;
		this.dateReservation = dateReservation;
		this.datePrise = datePrise;
		this.dateRetour = dateRetour;
		this.client = client;
		this.voiture = voiture;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public Date getDatePrise() {
		return datePrise;
	}

	public void setDatePrise(Date datePrise) {
		this.datePrise = datePrise;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	
}
