package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.persistence.entities.Tournament;
import project.service.TournamentService;

@Controller
public class TournamentResultController {
	
	TournamentService tournamentService;
	
	
	@Autowired
    public TournamentResultController(TournamentService tournamentService) {
		this.tournamentService = tournamentService;
	}
	
	@RequestMapping(value = "/results", method = RequestMethod.GET)
    public String results(Model model){
    	List<Tournament> tournaments = tournamentService.findAll();
    	System.out.println(tournaments.get(0).getid());
    	model.addAttribute("tournaments", tournaments);
    	
        return "results";
    }
	
	@RequestMapping(value="/tournament/{id}", method=RequestMethod.GET)
	public String displayTournament(@PathVariable(value="id") String id,
			Model model) {
		Tournament tournament = tournamentService.findOne(Long.parseLong(id));
		
		model.addAttribute("golfers", tournament.getPlayers());
		model.addAttribute("course", tournament.getCourse());
		model.addAttribute("name", tournament.getName());
		model.addAttribute("startdate", tournament.getStartDate());
		return "tournament";
	}
}
