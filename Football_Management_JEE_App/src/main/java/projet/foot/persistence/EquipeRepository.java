package projet.foot.persistence;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projet.foot.entities.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long>  {
	public Collection<Equipe> findByPays(String pays);
	public Equipe findByNomEquipe(String nomEquipe);
}
