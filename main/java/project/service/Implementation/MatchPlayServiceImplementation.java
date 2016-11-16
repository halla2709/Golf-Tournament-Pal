package project.service.Implementation;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.Golfer;
import project.persistence.entities.MatchPlayTournament;
import project.persistence.repositories.MatchPlayCreatorRepository;
import project.service.MatchPlayCreator;
import project.service.MatchPlayService;

@Service
public class MatchPlayServiceImplementation implements MatchPlayService {

	MatchPlayCreatorRepository repository;
	
	@Autowired
	public MatchPlayServiceImplementation(MatchPlayCreatorRepository repository) {
		this.repository = repository;
	}
	
	/**
	 * Miðað við gefnar upplýsingar er athugað hvort hægt sé að setja upp mót. Ef það er hægt
	 * er mótið vistað í gagnagrunninn. Annars er skilað null.
	 */
	@Override
	public MatchPlayTournament save(boolean areBrackets, List<Golfer> players, int numInBracket, int numOutOfBrackets, String course, String name, Date startDate) {
		
		MatchPlayCreator creator = new MatchPlayCreator(areBrackets, players, numInBracket, numOutOfBrackets);
		if(!creator.playerNumberValidator()) return null;
		
		MatchPlayTournament newt = creator.createTournament(course, name, startDate);
		repository.save(newt);
		return newt;
	}

	@Override
	public void delete(MatchPlayTournament headontournament) {
		repository.delete(headontournament);
	}

	@Override
	public List<MatchPlayTournament> findAll() {
		return repository.findAll();
		
	}

	@Override
	public List<MatchPlayTournament> findAllReverseOrder() {
		// Get all the Postit notes
        List<MatchPlayTournament> postitNotes = repository.findAll();

        // Reverse the list
        Collections.reverse(postitNotes);

        return postitNotes;
	}

	@Override
	public MatchPlayTournament findOne(Long id) {
		return repository.findOne(id);
	}


}
