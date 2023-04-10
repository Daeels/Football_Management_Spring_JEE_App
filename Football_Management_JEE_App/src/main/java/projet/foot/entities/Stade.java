package projet.foot.entities;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Stade {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idStade;
	
	@Column
	String nomStade;
	
	@Column
	String ville;
	
	@OneToMany(cascade= CascadeType.MERGE,mappedBy = "stade")
	@JsonManagedReference
	Collection <Matche> matchs;

	public Long getIdStade() {
		return idStade;
	}

	public void setIdStade(Long idStade) {
		this.idStade = idStade;
	}

	public String getNomStade() {
		return nomStade;
	}

	public void setNomStade(String nomStade) {
		this.nomStade = nomStade;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Collection<Matche> getMatchs() {
		return matchs;
	}

	public void setMatchs(Collection<Matche> matchs) {
		this.matchs = matchs;
	}
		
}
