package projet.foot.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
public class Joueur {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idJoueur;
	@Column
	String nomJoueur;
	@Column
	String poste;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonBackReference
	Equipe equipe;
	
	
	public Joueur() {
		super();
	}

	public Long getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(Long idJoueur) {
		this.idJoueur = idJoueur;
	}

	public String getNomJoueur() {
		return nomJoueur;
	}

	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
	
}
