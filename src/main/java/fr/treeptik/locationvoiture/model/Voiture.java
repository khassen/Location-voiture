package fr.treeptik.locationvoiture.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="voiture")
public class Voiture implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
//	@NotEmpty(message="saisir une marque")
	@NotEmpty
	private String marque;
	
//	@NotBlank(message="saisir un modele")
//	@Size(min=3, max=10,message="modele entre 3 et 10")
	@NotBlank
	@Size(min=3, max=10)
	private String model;
	
	@DateTimeFormat
	private Date dateMiseEnCirculation;
	
	public Voiture() {
		super();
	}
	public Voiture(Integer id, String marque, String model) {
		super();
		this.id = id;
		this.marque = marque;
		this.model = model;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Date getDateMiseEnCirculation() {
		return dateMiseEnCirculation;
	}
	public void setDateMiseEnCirculation(Date dateMiseEnCirculation) {
		this.dateMiseEnCirculation = dateMiseEnCirculation;
	}

}
