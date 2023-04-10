package projet.foot.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import projet.foot.entities.Equipe;
import projet.foot.persistence.EquipeRepository;

@Service
public class EquipeService {
	@Autowired
	EquipeRepository equipRepo;
	
	public Collection<Equipe> getAllEqui() {
		return equipRepo.findAll();
	}
	public Equipe getEquiByid(Long id) {
		return equipRepo.findById(id).get();
	}
	public Equipe addEqui(Equipe e) {
		return equipRepo.save(e);
	}
	public Collection<Equipe> getByPays(String pays) {
		return equipRepo.findByPays(pays);
	}
	public Equipe findByNomEq(String name) {
		return equipRepo.findByNomEquipe(name);
	}
	public ResponseEntity<Equipe> updateEqui(Long id, Equipe e){
		Equipe equ = equipRepo.getOne(id); 
		equ.setNomEquipe(e.getNomEquipe());
		equ.setPays(e.getPays());
		equ.setJoueur(e.getJoueur());
		equ.setMatches(e.getMatches());
		Equipe updatedEqui = equipRepo.save(equ);
		return ResponseEntity.ok(updatedEqui);
	}
	public void deleteEqui(Long id) {
		equipRepo.deleteById(id);
	}
}
