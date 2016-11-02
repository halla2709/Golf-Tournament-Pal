package project.service;

import java.util.List;

import project.persistence.entities.Golfer;
import project.persistence.entities.HeadOnTournament;

public interface HeadOnService {
	
	HeadOnTournament save(HeadOnTournament headontournament);
	
	void delete(HeadOnTournament headontournament);

}
