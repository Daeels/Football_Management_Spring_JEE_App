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

import projet.foot.entities.Stade;
import projet.foot.service.StadeService;

@RestController
public class StadeController {

	@Autowired
	StadeService stdserv;
	
	@GetMapping("/std")
	public Collection<Stade> getAllStade() {
		return stdserv.getAllStade();
	}
	@GetMapping("/std/{id}")
	public Stade getStadebyid(@PathVariable Long id ) {
		return stdserv.getStadeByid(id);
	}
	

	@PostMapping("/std")
	public Stade addEquip(@RequestBody Stade s) {
		return stdserv.addStade(s);
	}
	
	@PutMapping("/std/{id}")
	public ResponseEntity<Stade> updateStade(@PathVariable Long id, @RequestBody Stade s) {
		return stdserv.updateStade(id, s);
	}
	
	@DeleteMapping("/std/{id}")
	public void deleteStade(@PathVariable Long id) {
		stdserv.deleteStad(id);
	}
}
