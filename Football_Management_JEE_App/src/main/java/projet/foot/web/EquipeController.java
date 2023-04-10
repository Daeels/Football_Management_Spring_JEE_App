package projet.foot.web;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import projet.foot.entities.Equipe;
import projet.foot.entities.Joueur;
import projet.foot.service.EquipeService;

@RestController
public class EquipeController {


	@Autowired
	EquipeService eqpServ;
	
	@GetMapping("/equip")
	public Collection<Equipe> getAllEqui() {
		return eqpServ.getAllEqui();
	}
	@GetMapping("/equip/{id}")
	public Equipe getequipbyid(@PathVariable Long id ) {
		return eqpServ.getEquiByid(id);
	}
	@GetMapping("/equipe/{pays}")
	public Collection<Equipe> getpays(@PathVariable String pays) {
		return eqpServ.getByPays(pays);
	}
	@GetMapping("/equipee/{name}")
	public Collection<Joueur> findByNomEq(@PathVariable String name) {
		return eqpServ.findByNomEq(name).getJoueur();
	}
	@GetMapping("/equipi/{poste}/{ekip}")
	public Collection<Joueur> findByNomEq(@PathVariable String poste,@PathVariable String ekip ) {
		Collection<Joueur> Jr = eqpServ.findByNomEq(ekip).getJoueur();
		Jr.removeIf(i -> (!i.getPoste().equals(poste)));
		return Jr;
	}
	
	@PostMapping("/equip")
	public Equipe addEquip(@RequestBody Equipe e) {
		return eqpServ.addEqui(e);
	}
	
	@PutMapping("/equip/{id}")
	public ResponseEntity<Equipe> updateEquip(@PathVariable Long id, @RequestBody Equipe e) {
		return eqpServ.updateEqui(id, e);
	}
	
	@DeleteMapping("/equip/{id}")
	public void deleteEquip(@PathVariable Long id) {
		eqpServ.deleteEqui(id);
	}
}
