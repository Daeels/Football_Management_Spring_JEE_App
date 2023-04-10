package projet.foot.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import projet.foot.entities.Arbitre;
import projet.foot.persistence.ArbitreRepository;

@Service
public class ArbitreService {
	@Autowired
	ArbitreRepository arbRepo;
	
	public Collection<Arbitre> getAllArb() {
		return arbRepo.findAll();
	}
	public Arbitre getArbByid(Long id) {
		return arbRepo.findById(id).get();
	}
	public Arbitre addArb(Arbitre a) {
		return arbRepo.save(a);
	}
	public void deleteArb(Long id) {
		arbRepo.deleteById(id);
	}
	public ResponseEntity<Arbitre> updateArb(Long id, Arbitre a){
		Arbitre arb = arbRepo.getOne(id); 
		arb.setNom(a.getNom());
		arb.setNationalité(a.getNationalité());
		arb.setMatches(a.getMatches());
		Arbitre updatearb = arbRepo.save(arb);
		return ResponseEntity.ok(updatearb);
	}
	
}
