package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.persistence.entities.Bracket;
import project.persistence.entities.Golfer;
import project.persistence.entities.MatchPlayTournament;
import project.persistence.entities.PlayOffTree;
import project.persistence.entities.ScoreboardTournament;
import project.persistence.entities.Tournament;
import project.service.MatchPlayService;
import project.service.ScoreboardService;
import project.service.TournamentService;

@Controller
public class TournamentResultController {
	
	TournamentService tournamentService;
	MatchPlayService matchPlayService;
	ScoreboardService scoreboardService;
	
	
	@Autowired
    public TournamentResultController(TournamentService tournamentService, MatchPlayService matchPlayService, ScoreboardService scoreboardService) {
		this.tournamentService = tournamentService;
		this.matchPlayService = matchPlayService;
		this.scoreboardService = scoreboardService;
	}
	
	@RequestMapping(value = "/results", method = RequestMethod.GET)
    public String results(Model model){
    	List<Tournament> tournaments = tournamentService.findAll();
    	if(tournaments == null) model.addAttribute("tournaents", null);
    	else model.addAttribute("tournaments", tournaments);
    	
        return "results";
    }
	
	@RequestMapping(value="/tournament/{id}", method=RequestMethod.GET)
	public String displayTournament(@PathVariable(value="id") Long id,
			Model model) {
		Tournament tournament = tournamentService.findOne(id);
		
		model.addAttribute("golfers", tournament.getPlayers());
		model.addAttribute("course", tournament.getCourse());
		model.addAttribute("name", tournament.getName());
		model.addAttribute("startdate", tournament.getStartDate());
		model.addAttribute("id", tournament.getid());
		
		if(tournament instanceof MatchPlayTournament) {
			return "matchPlayTournament";
		}
		else if(tournament instanceof ScoreboardTournament) {
			model.addAttribute("scoreboard", ((ScoreboardTournament) tournament).getScores());
			model.addAttribute("numberOfRounds", ((ScoreboardTournament) tournament).getNumberOfRounds());
			return "scoreboardTournament";
		}
		
		return "tournament";
	}
	
	@RequestMapping(value="/tournament/{id}/{social}/{round}", method=RequestMethod.GET)
	public String addRound(@PathVariable(value="id") Long id, 
			@PathVariable(value="social") long social,
			@PathVariable(value="round") int round) {
		return "roundInsert";
	}
	
	@RequestMapping(value="/tournament/{id}/playofftree", method=RequestMethod.GET)
	public String displayPlayoffs(@PathVariable(value="id") Long id,
			Model model) {
		
		PlayOffTree playoffs = matchPlayService.getPlayOffTree(id);
		
		model.addAttribute("rounds", playoffs.getRounds());
		model.addAttribute("numberOfRounds", playoffs.getRounds().size());
		model.addAttribute("numberOfMatches", Math.pow(2, playoffs.getRounds().size()-1));
		return "playoffs";
	}
	
	@RequestMapping(value="/tournament/{id}/playofftree", method=RequestMethod.POST)
	public String addPlayoffResults(@PathVariable(value="id") Long id,
			@RequestParam(value = "player", required=false) Long player,
			@RequestParam(value = "roundNum", required=false) Integer roundNum,
			Model model) {
		
		PlayOffTree playoffs = matchPlayService.addPlayoffMatchResults(id, player, roundNum);
		
		model.addAttribute("rounds", playoffs.getRounds());
		model.addAttribute("numberOfRounds", playoffs.getRounds().size());
		model.addAttribute("numberOfMatches", Math.pow(2, playoffs.getRounds().size()-1));
		return "playoffs";
	}
	
	@RequestMapping(value="/tournament/{id}/brackets", method=RequestMethod.GET)
	public String displayBrackets(@PathVariable(value="id") Long id,
			Model model) {
		
		List<Bracket> brackets = matchPlayService.getBrackets(id);
		model.addAttribute("brackets", brackets);
		model.addAttribute("numberOfBrackets", brackets.size());
		return "brackets";
	}
	
}
