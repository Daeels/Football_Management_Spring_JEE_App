package projet.foot.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import projet.foot.entities.Stade;
import projet.foot.persistence.StadeRepository;

@Service
public class StadeService {

	@Autowired
	StadeRepository stadrep;
	
	public Collection<Stade> getAllStade() {
		return stadrep.findAll();
	}
	public Stade getStadeByid(Long id) {
		return stadrep.findById(id).get();
	}
	public Stade  addStade(Stade s) {
		return stadrep.save(s);
	}
	public ResponseEntity<Stade> updateStade(Long id, Stade s){
		Stade sat = stadrep.getOne(id); 
		sat.setNomStade(s.getNomStade());
		sat.setVille(s.getVille());
		sat.setMatchs(s.getMatchs());
		
		Stade updatedstad = stadrep.save(sat);
		return ResponseEntity.ok(updatedstad);
	}
	public void deleteStad(Long id) {
		stadrep.deleteById(id);
	}
}