package project.service;

import java.util.List;

import project.persistence.entities.Golfer;

public interface GolferService {
	
	Golfer save(Golfer player);

	List<Golfer> findAll();
	
	Golfer delete(Golfer player);
	
}	

