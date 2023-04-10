package projet.foot.persistence;

import org.springframework.stereotype.Repository;

import projet.foot.entities.Arbitre;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ArbitreRepository extends JpaRepository<Arbitre, Long>  {

}
