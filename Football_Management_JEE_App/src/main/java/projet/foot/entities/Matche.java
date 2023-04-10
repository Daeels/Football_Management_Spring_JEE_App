package projet.foot.entities;


import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;



import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



@Entity
public class Matche {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idMatch;
	
	@Column
	@Temporal(TemporalType.DATE)
	Date dateMatch;
	
	@Column
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern="HH:mm:ss")
	Date heureMatch;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	Arbitre arbitre;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonBackReference
	Stade stade;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "matches_equipes", joinColumns = @JoinColumn(name = "matches_id", referencedColumnName = "idMatch"), 
    inverseJoinColumns = @JoinColumn(name = "equipes_id", referencedColumnName = "idEquipe"))
	Collection<Equipe> equipes;

	
	public Matche() {
		super();
	}


	public Long getIdMatch() {
		return idMatch;
	}


	public void setIdMatch(Long idMatch) {
		this.idMatch = idMatch;
	}


	public Date getDateMatch() {
		return dateMatch;
	}


	public void setDateMatch(Date dateMatch) {
		this.dateMatch = dateMatch;
	}


	public Date getHeureMatch() {
		return heureMatch;
	}


	public void setHeureMatch(Date heureMatch) {
		this.heureMatch = heureMatch;
	}


	public Arbitre getArbitre() {
		return arbitre;
	}


	public void setArbitre(Arbitre arbitre) {
		this.arbitre = arbitre;
	}


	public Stade getStade() {
		return stade;
	}


	public void setStade(Stade stade) {
		this.stade = stade;
	}


	public Collection<Equipe> getEquipes() {
		return equipes;
	}


	public void setEquipes(Collection<Equipe> equipes) {
		this.equipes = equipes;
	}
	
	
	
	

}
