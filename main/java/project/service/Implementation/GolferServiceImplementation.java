package project.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.Golfer;
import project.persistence.repositories.GolferRepository;
import project.service.GolferService;

@Service
public class GolferServiceImplementation implements GolferService{

	
	private GolferRepository repository;
	
	@Autowired
	public GolferServiceImplementation(GolferRepository repository) {
		this.repository = repository;
	}
	@Override
	public Golfer save(Golfer player) {
		return repository.save(player);
	}
	@Override
	public List<Golfer> findAll() {
		return repository.findAll();
	}

}
