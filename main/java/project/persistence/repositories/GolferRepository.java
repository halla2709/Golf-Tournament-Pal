package project.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.persistence.entities.Golfer;
import project.persistence.entities.HeadOnTournament;

public interface GolferRepository extends JpaRepository<Golfer, Long>{
	
	Golfer save(Golfer golfer);
	
	void delete(Golfer golfer);

}
