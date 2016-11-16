package project.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.Tournament;
import project.persistence.repositories.TournamentRepository;
import project.service.TournamentService;

@Service
public class TournamentServiceImplementation implements TournamentService {
	
	TournamentRepository repository;
	
	@Autowired
	public TournamentServiceImplementation(TournamentRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Tournament> findAll() {
		return repository.findAll();
	}

	@Override
	public Tournament findOne(Long id) {
		return repository.findOne(id);
	}

}
