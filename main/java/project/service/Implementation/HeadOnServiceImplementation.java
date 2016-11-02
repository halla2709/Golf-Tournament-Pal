package project.service.Implementation;

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
		System.out.println("??");
		this.repository = repository;
	}
		
	@Override
	public HeadOnTournament save(HeadOnTournament headontournament) {
		
		System.out.println("tournament saving");
		return repository.save(headontournament);
	}

	@Override
	public void delete(HeadOnTournament headontournament) {
		repository.delete(headontournament);
	}


}
