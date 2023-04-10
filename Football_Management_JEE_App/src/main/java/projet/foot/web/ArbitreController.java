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

import projet.foot.entities.Arbitre;
import projet.foot.service.ArbitreService;


@RestController
public class ArbitreController {


	@Autowired
	ArbitreService arbServ;
	
	@GetMapping("/Arbt")
	public Collection<Arbitre> getAllarb() {
		return arbServ.getAllArb();
	}
	@GetMapping("/Arbt/{id}")
	public Arbitre getArbbyid(@PathVariable Long id ) {
		return arbServ.getArbByid(id);
	}

	@PostMapping("/Arbt")
	public Arbitre addArb(@RequestBody Arbitre a) {
		return arbServ.addArb(a);
	}
	
	@PutMapping("/Arbt/{id}")
	public ResponseEntity<Arbitre> updateArb(@PathVariable Long id, @RequestBody Arbitre a) {
		return arbServ.updateArb(id, a);
	}
	
	@DeleteMapping("/Arbt/{id}")
	public void deleteArb(@PathVariable Long id) {
		arbServ.deleteArb(id);
	}
}