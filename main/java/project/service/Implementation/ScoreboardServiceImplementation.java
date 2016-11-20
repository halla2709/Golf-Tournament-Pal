package project.service.Implementation;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.Golfer;
import project.persistence.entities.MatchPlayTournament;
import project.persistence.entities.ScoreboardTournament;
import project.persistence.repositories.ScoreboardCreatorRepository;
import project.service.MatchPlayCreator;
import project.service.MatchPlayService;
import project.service.ScoreboardCreator;
import project.service.ScoreboardService;

@Service
public class ScoreboardServiceImplementation implements ScoreboardService {

	ScoreboardCreatorRepository repository;
	
	@Autowired
	public ScoreboardServiceImplementation(ScoreboardCreatorRepository repository) {
		this.repository = repository;
	}
	
	/**
	 * Mi�a� vi� gefnar uppl�singar er athuga� hvort h�gt s� a� setja upp m�t. Ef �a� er h�gt
	 * er m�ti� vista� � gagnagrunninn. Annars er skila� null.
	 */
	@Override
	public ScoreboardTournament save(List<Golfer> players, int numberOfRounds, String course, String name, Date startDate) {
		
		ScoreboardCreator creator = new ScoreboardCreator(players, numberOfRounds, course, name, startDate);
		
		ScoreboardTournament newt = creator.createTournament();
		repository.save(newt);
		return newt;
	}

	@Override
	public void delete(ScoreboardTournament scoreboardtournament) {
		repository.delete(scoreboardtournament);
	}

	@Override
	public List<ScoreboardTournament> findAll() {
		return repository.findAll();
		
	}


	@Override
	public ScoreboardTournament findOne(Long id) {
		return repository.findOne(id);
	}


}
