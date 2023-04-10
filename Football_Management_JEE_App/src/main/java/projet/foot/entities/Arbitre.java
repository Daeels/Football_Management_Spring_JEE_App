package projet.foot.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;






@Entity

public class Arbitre {
	@Id 
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idArbitre;
	
	@Column
	String nom;
	
	@Column
	String Nationalité;
	
	@OneToMany(cascade= CascadeType.MERGE,mappedBy = "arbitre")
	@JsonIgnore
	Collection <Matche> matches;
	
	public Arbitre() {
		super();
	}
	public Long getIdArbitre() {
		return idArbitre;
	}
	public void setIdArbitre(Long idArbitre) {
		this.idArbitre = idArbitre;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNationalité() {
		return Nationalité;
	}
	public void setNationalité(String nationalité) {
		Nationalité = nationalité;
	}
	public Collection<Matche> getMatches() {
		return matches;
	}
	public void setMatches(Collection<Matche> matches) {
		this.matches = matches;
	}
	
	
	
	
}
