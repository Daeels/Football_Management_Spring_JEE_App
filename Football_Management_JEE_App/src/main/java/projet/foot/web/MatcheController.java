package projet.foot.web;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projet.foot.entities.Equipe;
import projet.foot.entities.Matche;
import projet.foot.entities.Stade;
import projet.foot.service.MatcheService;

@RestController
public class MatcheController {

	@Autowired
	MatcheService matserv;
	
	@GetMapping("/match")
	public Collection<Matche> getAllMatche() {
		return matserv.getAllMatch();
	}
	@GetMapping("/match/{id}")
	public Matche getMatchpbyid(@PathVariable Long id ) {
		return matserv.getMatchByid(id);
	}
	//6
	@GetMapping("/mo/{id}")
	public Stade getMatchopbyid(@PathVariable Long id ) {
		return matserv.getMatchByid(id).getStade();
	}
	@GetMapping("/ma/{id}")
	public Collection<Equipe> getEquipee(@PathVariable Long id ) {
		return  matserv.getMatchByid(id).getEquipes();
	}
	

	@PostMapping("/match")
	public Matche addMatch(@RequestBody Matche m) {
		return matserv.addMatch(m);
	}
	//5
	@GetMapping("/matches")
	public Collection<Matche> getMatchBydate(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		return matserv.findMatcheByDate(date);
	}
	@DeleteMapping("/matches")
	public Collection<Matche> removeByDateMatchLessThan(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		return matserv.removeByDateMatchLessThan(date);
	}
	
	@PutMapping("/match/{id}")
	public ResponseEntity<Matche> updateMatch(@PathVariable Long id, @RequestBody Matche m) {
		return matserv.updateMatch(id, m);
	}
	
	@DeleteMapping("/match/{id}")
	public void deleteMatch(@PathVariable Long id) {
		matserv.deleteMatch(id);
	}

}
