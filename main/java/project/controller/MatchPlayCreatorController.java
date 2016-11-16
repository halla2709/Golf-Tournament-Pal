package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.persistence.entities.Golfer;
import project.persistence.entities.MatchPlayTournament;
import project.service.GolferService;
import project.service.MatchPlayService;

@Controller
public class MatchPlayCreatorController {
	
	MatchPlayService headOnService;
	GolferService golferService;
	
	MatchPlayTournament tournament;
	Integer numOutOfBrackets;
	Integer numberInBrackets;
	boolean beenhere;
	
	@Autowired
	public MatchPlayCreatorController(MatchPlayService headOnService, GolferService golferService){
		this.headOnService = headOnService;
		this.golferService = golferService;
		beenhere = false;
	}
	
	/**
	 * Birtir upphafss��u ferlisins a� b�a til MatchPlay/HeadOn m�t. 
	 */
	@RequestMapping(value="/matchplay", method = RequestMethod.GET)
	public String matchplay2(Model model) { 

		model.addAttribute("headOnTournament", new MatchPlayTournament());
		tournament = new MatchPlayTournament();
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
	public String addPlayersToMatchplayers(@ModelAttribute("headOnTournament") MatchPlayTournament headOnTournament,
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
		
		else {
    		System.out.println("Saving golfer " + golfer.getName());
    		tournament.addPlayer(golfer);
    		golferService.save(golfer);
    		System.out.println(tournament.getPlayers().size());
    	}
    	
    	    	
    	model.addAttribute("golfer", new Golfer());
    	model.addAttribute("golfers", tournament.getPlayers());
    	
    	return "wow";
	}
	
	@RequestMapping(value="/addplayers", method = RequestMethod.GET) 
	public String backFromErrorPage(Model model){
		
		System.out.println(tournament.getPlayers().size());
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

		MatchPlayTournament newtournament = headOnService.save(tournament.isAreBrackets(), tournament.getPlayers(),
				numberInBrackets, numOutOfBrackets, tournament.getCourse(), tournament.getName(), tournament.getStartDate());
			
		if(newtournament == null) return "villusida";
		
		System.out.println(newtournament.getPlayOffs().getRounds().get(0).getMatches().size());
		model.addAttribute("golfers", newtournament.getPlayers());
		model.addAttribute("brackets", newtournament.getBrackets());
		model.addAttribute("playofftree", newtournament.getPlayOffs());
		model.addAttribute("course", newtournament.getCourse());
		model.addAttribute("startdate", newtournament.getStartDate());
		model.addAttribute("name", newtournament.getName());
		beenhere = false;
		return "matchplay2";
	}
}
