package project.persistence.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.persistence.entities.Golfer;
import project.persistence.entities.HeadOnTournament;

public interface HeadOnCreatorRepository extends JpaRepository<HeadOnTournament, Long>{
	
	HeadOnTournament save(HeadOnTournament headontournament);
	
	void delete(HeadOnTournament headontournament);

	//Golfer save(Golfer players);
	
}
