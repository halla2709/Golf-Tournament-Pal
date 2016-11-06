package project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.persistence.entities.Golfer;
import project.persistence.entities.HeadOnTournament;
import project.service.GolferService;
import project.service.HeadOnService;

@Controller
public class HeadOnCreatorController {
	
	HeadOnService headOnService;
	GolferService golferService;
	
	HeadOnTournament tournament;
	
	@Autowired
	public HeadOnCreatorController(HeadOnService headOnService, GolferService golferService){
		this.headOnService = headOnService;
		this.golferService = golferService;
	}
	
	public HeadOnTournament save(HeadOnTournament tournament){
		return headOnService.save(tournament);
	}
	
	@RequestMapping(value="/matchplay", method = RequestMethod.GET)
	public String matchplay2(Model model) { 

		model.addAttribute("headOnTournament", new HeadOnTournament());
		
		return "matchplay";
	}
	
	@RequestMapping(value="/addplayers", method = RequestMethod.POST)
	public String addPlayersToMatchplayers(@ModelAttribute("headOnTournament") HeadOnTournament headOnTournament,
											@ModelAttribute("golfer") Golfer golfer,
											@RequestParam(value = "numOutOfBrackets", required=false) Integer numOutOfBrackets,
											Model model) {
		System.out.println("numoob " + numOutOfBrackets);
		
		if(numOutOfBrackets!=null) {
			tournament = headOnTournament;
		}
		
		System.out.println(tournament.getCourse());
		
    	if(golfer.getName()!=null) {
    		System.out.println("Saving golfer " + golfer.getName());
    		tournament.addPlayer(golfer);
    		golferService.save(golfer);
    		System.out.println("player added " + golfer.getName());
    	}
    	
    	    	
    	model.addAttribute("golfer", new Golfer());
    	model.addAttribute("golfers", tournament.getPlayers());
    	
		return "wow";
	}
	
}
