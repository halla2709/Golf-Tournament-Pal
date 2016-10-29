package project.service;

import project.persistence.entities.HeadOnTournament;

public interface HeadOnService {
	
	HeadOnTournament save(HeadOnTournament headontournament);
	
	void delete(HeadOnTournament headontournament);
	
}
