package projet.foot.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projet.foot.entities.Joueur;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long>  {

}
