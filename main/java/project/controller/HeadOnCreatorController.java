package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.persistence.entities.Golfer;
import project.persistence.entities.HeadOnTournament;
import project.persistence.repositories.HeadOnCreatorRepository;
import project.service.HeadOnService;

@Controller
public class HeadOnCreatorController {
	
	HeadOnService headOnService;
	
	@Autowired
	public HeadOnCreatorController(HeadOnService headOnService){
		this.headOnService = headOnService;
	}
	
	public HeadOnTournament save(HeadOnTournament tournament){
		return headOnService.save(tournament);
	}
	
	@RequestMapping(value="/prufa", method = RequestMethod.GET)
	public String prufaprufa() { 
		System.out.println("Byrja prufu");
		
		Golfer halla = new Golfer("Halla", 93939393, 4.3, "hallamammain");
		Golfer elvar = new Golfer("Elvar", 93939393, 36.0, "ilvar");
		Golfer mamma = new Golfer("begga", 93939393, 33.4, "hallamammain");
		Golfer pabbi = new Golfer("raggi", 93939393, 6.8, "ilvar");		
		Golfer hedda = new Golfer("hedda", 93939393, 12.2, "hallamammain");
		Golfer brynja = new Golfer("brynja", 93939393, 24.2, "ilvar");
		Golfer[] unsorted = {mamma, halla, elvar, pabbi};
		HeadOnCreator headOnCreator = new HeadOnCreator(false, unsorted, 3, 2);
		HeadOnTournament tournament = headOnCreator.createTournament();
		System.out.println("Stopp..");
		headOnService.save(tournament);
		System.out.println("Her?");
		return "prufa";
	}
	
}
