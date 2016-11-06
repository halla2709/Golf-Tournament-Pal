package project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.persistence.entities.Golfer;
import project.persistence.entities.ScoreboardTournament;
import project.service.GolferService;

@Controller
public class ScoreboardCreatorController {

	GolferService golferService;
	
	@Autowired
	public ScoreboardCreatorController(GolferService golferService){
		this.golferService = golferService;
	}
	
    @RequestMapping(value = "/prufaprufa", method = RequestMethod.GET)
    public String postitNoteViewGet(Model model){

        // Add a new Postit Note to the model for the form
        // If you look at the form in PostitNotes.jsp, you can see that we
        // reference this attribute there by the name `postitNote`.
        model.addAttribute("golfer", new Golfer());
        
        model.addAttribute("golfers", golferService.findAll());
        
        return "prufa";
    }
    
    @RequestMapping(value = "/prufaprufa", method = RequestMethod.POST)
    public String postitNoteViewPost(@ModelAttribute("golfer") Golfer golfer,
                                     Model model){

        // Save the Postit Note that we received from the form
        golferService.save(golfer);

        // Here we get all the Postit Notes (in a reverse order) and add them to the model
        model.addAttribute("golfers", golferService.findAll());

        // Add a new Postit Note to the model for the form
        // If you look at the form in PostitNotes.jsp, you can see that we
        // reference this attribute there by the name `postitNote`.
        model.addAttribute("golfer", new Golfer());

        // Return the view
        return "prufa";
    }



    @RequestMapping(value="/scoreboardprufa", method = RequestMethod.GET)
    public String scoreboardprufuGet(Model model) {
    	
    	model.addAttribute("scoreboard", new ScoreboardTournament());
    	
    	return "enneinprufa";
    }
    
    @RequestMapping(value="/wow", method = RequestMethod.POST)
    public String postAScoreboard(@ModelAttribute("scoreboard") ScoreboardTournament scoreboard,
    								@ModelAttribute("golfer") Golfer golfer,
    								Model model) {
    	
    	if(golfer.getName()!=null) {
    		golferService.save(golfer);
    		scoreboard.addPlayer(golfer);
    	}
    	
    	
    	model.addAttribute("golfer", new Golfer());
    	model.addAttribute("golfers", scoreboard.getPlayers());
    	return "wow";
    }

	
}
