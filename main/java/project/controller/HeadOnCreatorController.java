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
	Integer numOutOfBrackets;
	Integer numberInBrackets;
	boolean beenhere;
	
	@Autowired
	public HeadOnCreatorController(HeadOnService headOnService, GolferService golferService){
		this.headOnService = headOnService;
		this.golferService = golferService;
		beenhere = false;
	}
	
	/**
	 * Birtir upphafss��u ferlisins a� b�a til MatchPlay/HeadOn m�t. 
	 */
	@RequestMapping(value="/matchplay", method = RequestMethod.GET)
	public String matchplay2(Model model) { 

		model.addAttribute("headOnTournament", new HeadOnTournament());
		tournament = new HeadOnTournament();
		numOutOfBrackets = 0;
		numberInBrackets = 0;
		beenhere = false;
		
		return "matchplay";
	}
	
	/**
	 * Birtir s��u sem er til �ess a� b�ta vi� leikm�nnum � m�t. 
	 * 
	 */
	@RequestMapping(value="/addplayers", method = RequestMethod.POST)
	public String addPlayersToMatchplayers(@ModelAttribute("headOnTournament") HeadOnTournament headOnTournament,
											@ModelAttribute("golfer") Golfer golfer,
											@RequestParam(value = "numOutOfBrackets", required=false) Integer numOutOfBrackets,
											@RequestParam(value = "numberInBrackets", required=false) Integer numberInBrackets,
											Model model) {
		
		System.out.println("numoob " + numOutOfBrackets);
		System.out.println("number in brackets " + numberInBrackets);
		if(!beenhere) {
			tournament = headOnTournament;
			this.numOutOfBrackets = numOutOfBrackets;
			this.numberInBrackets = numberInBrackets;
			beenhere = true;
		}
		
		System.out.println(tournament.getCourse());
		
    	if(golfer.getName() != null) {
    		System.out.println("Saving golfer " + golfer.getName());
    		tournament.addPlayer(golfer);
    		golferService.save(golfer);
    		System.out.println("player added " + golfer.getName());
    	}
    	
    	    	
    	model.addAttribute("golfer", new Golfer());
    	model.addAttribute("golfers", tournament.getPlayers());
    	
		return "wow";
	}
	
	/*
	 * �egar allir leikmenn eru komnir � m�ti� er athuga� hvort fj�ldinn passi
	 * mi�a� vi� reglur sem settar eru fram � HeadOnCreator. Ef fj�ldinn passar
	 * ekki birtist villus��a.
	 */
	@RequestMapping(value="/matchplay2", method = RequestMethod.POST)
	public String showTournament(Model model) { 
		if(numberInBrackets == null) numberInBrackets = 0;
		if(numOutOfBrackets == null) numOutOfBrackets = 0;

		tournament = headOnService.save(tournament.isAreBrackets(), tournament.getPlayers(),
				numberInBrackets, numOutOfBrackets, tournament.getCourse(), tournament.getStartDate());
		
		model.addAttribute("golfers", tournament.getPlayers());
		model.addAttribute("brackets", tournament.getBrackets());
		model.addAttribute("playofftree", tournament.getPlayOffs());
		model.addAttribute("course", tournament.getCourse());
		model.addAttribute("startdate", tournament.getStartDate());
		
		return "matchplay2";
	}
}
