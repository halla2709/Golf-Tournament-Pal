package project.service.Implementation;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.controller.HeadOnCreator;
import project.persistence.entities.Golfer;
import project.persistence.entities.HeadOnTournament;
import project.persistence.repositories.HeadOnCreatorRepository;
import project.service.HeadOnService;

@Service
public class HeadOnServiceImplementation implements HeadOnService {

	HeadOnCreatorRepository repository;
	
	@Autowired
	public HeadOnServiceImplementation(HeadOnCreatorRepository repository) {
		this.repository = repository;
	}
		
	@Override
	public HeadOnTournament save(boolean areBrackets, List<Golfer> players, int numInBracket, int numOutOfBrackets, String course, Date startDate) {
		
		HeadOnCreator creator = new HeadOnCreator(areBrackets, players, numInBracket, numOutOfBrackets);
		if(!creator.playerNumberValidator()) return null;
		
		HeadOnTournament newt = creator.createTournament(course, startDate);
		repository.save(newt);
		return newt;
	}

	@Override
	public void delete(HeadOnTournament headontournament) {
		repository.delete(headontournament);
	}

	@Override
	public List<HeadOnTournament> findAll() {
		return repository.findAll();
		
	}

	@Override
	public List<HeadOnTournament> findAllReverseOrder() {
		// Get all the Postit notes
        List<HeadOnTournament> postitNotes = repository.findAll();

        // Reverse the list
        Collections.reverse(postitNotes);

        return postitNotes;
	}

	@Override
	public HeadOnTournament findOne(Long id) {
		return repository.findOne(id);
	}


}
