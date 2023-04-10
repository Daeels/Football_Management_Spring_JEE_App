package projet.foot.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projet.foot.entities.Stade;


@Repository
public interface StadeRepository extends JpaRepository<Stade, Long>  {

}
