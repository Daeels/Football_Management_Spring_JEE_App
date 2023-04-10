package projet.foot.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import projet.foot.entities.Matche;
import projet.foot.persistence.MatcheRepository;

@Service
public class MatcheService {

	@Autowired
	MatcheRepository matrep;
	
	public Collection<Matche> getAllMatch() {
		return matrep.findAll();
	}
	public Matche getMatchByid(Long id) {
		return matrep.findById(id).get();
	}
	public Matche  addMatch(Matche m) {
		return matrep.save(m);
	}
	public Collection<Matche> findMatcheByDate(Date date){
		return matrep.findByDateMatch(date);
	}
	public ResponseEntity<Matche> updateMatch(Long id, Matche m){
		Matche mat = matrep.getOne(id); 
		mat.setDateMatch(m.getDateMatch());
		mat.setHeureMatch(m.getHeureMatch());
		mat.setStade(m.getStade());
		mat.setArbitre(m.getArbitre());
		Matche updatedmat = matrep.save(mat);
		return ResponseEntity.ok(updatedmat);
	}
	public void deleteMatch(Long id) {
		matrep.deleteById(id);
	}
	public Collection<Matche> removeByDateMatchLessThan(Date datee) {
		return matrep.removeByDateMatchLessThan(datee);
	}
}
