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

import projet.foot.entities.Joueur;
import projet.foot.service.JoueurService;

@RestController
public class JoueurController {


	@Autowired
	JoueurService jrserv;
	
	@GetMapping("/jrs")
	public Collection<Joueur> getAllJoueurs() {
		return jrserv.getAllJrs();
	}
	@GetMapping("/jrs/{id}")
	public Joueur getJoueursbyid(@PathVariable Long id ) {
		return jrserv.getJrsByid(id);
	}
	

	@PostMapping("/jrs")
	public Joueur addJoueurs(@RequestBody Joueur j) {
		return jrserv.addJrs(j);
	}
	
	@PutMapping("/jrs/{id}")
	public ResponseEntity<Joueur> updateJoueurs(@PathVariable Long id, @RequestBody Joueur j) {
		return jrserv.updateJrs(id, j);
	}
	
	@DeleteMapping("/jrs/{id}")
	public void deleteJoueurs(@PathVariable Long id) {
		jrserv.deleteJrs(id);
	}

}
