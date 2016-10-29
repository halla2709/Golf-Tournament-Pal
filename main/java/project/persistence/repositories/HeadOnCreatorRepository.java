package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import project.persistence.entities.HeadOnTournament;

public interface HeadOnCreatorRepository extends JpaRepository<HeadOnTournament, Long>{
	
	HeadOnTournament save(HeadOnTournament headontournament);
	
	void delete(HeadOnTournament headontournament);
}
