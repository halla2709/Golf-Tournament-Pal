package project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.persistence.entities.Golfer;
import project.persistence.entities.HeadOnTournament;
import project.persistence.repositories.HeadOnCreatorRepository;
import project.service.GolferService;
import project.service.HeadOnService;

@Controller
public class HeadOnCreatorController {
	
	HeadOnService headOnService;
	GolferService golferService;
	
	@Autowired
	public HeadOnCreatorController(HeadOnService headOnService, GolferService golferService){
		this.headOnService = headOnService;
		this.golferService = golferService;
	}
	
	public HeadOnTournament save(HeadOnTournament tournament){
		return headOnService.save(tournament);
	}
	
	@RequestMapping(value="/prufa", method = RequestMethod.GET)
	public String prufaprufa() { 
		System.out.println("Byrja prufu");
		
		Golfer halla = new Golfer("Halla", 93939393, 4.3, "hallamammain");
		Golfer elvar = new Golfer("Elvar", 27272727, 36.0, "ilvar");
		Golfer mamma = new Golfer("begga", 9292929, 33.4, "hallamammain");
		Golfer pabbi = new Golfer("raggi", 18181818, 6.8, "ilvar");		
		Golfer hedda = new Golfer("hedda", 28282828, 12.2, "hallamammain");
		Golfer brynja = new Golfer("brynja", 4949494, 24.2, "ilvar");
		List<Golfer> unsorted = new ArrayList<>();
		unsorted.add(brynja);
		unsorted.add(elvar);
		unsorted.add(halla);
		unsorted.add(pabbi);
		unsorted.add(hedda);
		unsorted.add(mamma);
		HeadOnCreator headOnCreator = new HeadOnCreator(true, unsorted, 3, 2);
		
		HeadOnTournament tournament = headOnCreator.createTournament();
		
		golferService.save(halla);
		golferService.save(elvar);
		golferService.save(mamma);
		golferService.save(pabbi);
		golferService.save(hedda);
		golferService.save(brynja);
		
		headOnService.save(tournament);
		System.out.println("saved");
		return "prufa";
	}
	
}
