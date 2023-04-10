package projet.foot.service;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import projet.foot.entities.Joueur;
import projet.foot.persistence.JoueurRepository;

@Service
public class JoueurService {

	@Autowired
	JoueurRepository joureurRepo;
	
	public Collection<Joueur> getAllJrs() {
		return joureurRepo.findAll();
	}
	public Joueur getJrsByid(Long id) {
		return joureurRepo.findById(id).get();
	}
	public Joueur  addJrs(Joueur j) {
		return joureurRepo.save(j);
	}
	public ResponseEntity<Joueur> updateJrs(Long id, Joueur j){
		Joueur jrs = joureurRepo.getOne(id); 
		jrs.setNomJoueur(j.getNomJoueur());
		jrs.setPoste(j.getPoste());
		jrs.setEquipe(j.getEquipe());
		Joueur updatedjr = joureurRepo.save(jrs);
		return ResponseEntity.ok(updatedjr);
	}
	public void deleteJrs(Long id) {
		joureurRepo.deleteById(id);
	}
}
