package projet.foot.persistence;

import java.util.Collection;
import java.util.Date;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projet.foot.entities.Matche;


@Repository
public interface MatcheRepository extends JpaRepository<Matche, Long>  {
	public Collection<Matche> findByDateMatch(Date dateMatch);
	@Transactional
	public Collection<Matche> removeByDateMatchLessThan(Date dateCurrent);
}