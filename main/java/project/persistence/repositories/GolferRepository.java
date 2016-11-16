package project.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.persistence.entities.Golfer;
import project.persistence.entities.MatchPlayTournament;

public interface GolferRepository extends JpaRepository<Golfer, Long>{
	
	Golfer save(Golfer player);

	List<Golfer> findAll();
	
}
