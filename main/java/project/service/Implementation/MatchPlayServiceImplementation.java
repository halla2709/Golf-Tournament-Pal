package project.service.Implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.Bracket;
import project.persistence.entities.Golfer;
import project.persistence.entities.Match;
import project.persistence.entities.MatchPlayTournament;
import project.persistence.entities.PlayOffRound;
import project.persistence.entities.PlayOffTree;
import project.persistence.repositories.MatchPlayCreatorRepository;
import project.service.MatchPlayCreator;
import project.service.MatchPlayService;

@Service
public class MatchPlayServiceImplementation implements MatchPlayService {

	MatchPlayCreatorRepository repository;
	
	@Autowired
	public MatchPlayServiceImplementation(MatchPlayCreatorRepository repository) {
		this.repository = repository;
	}
	
	/**
	 * Miðað við gefnar upplýsingar er athugað hvort hægt sé að setja upp mót. Ef það er hægt
	 * er mótið vistað í gagnagrunninn. Annars er skilað null.
	 */
	@Override
	public MatchPlayTournament save(boolean areBrackets, List<Golfer> players, int numInBracket, int numOutOfBrackets, String course, String name, Date startDate) {
		
		MatchPlayCreator creator = new MatchPlayCreator(areBrackets, players, numInBracket, numOutOfBrackets);
		if(!creator.playerNumberValidator()) return null;
		
		MatchPlayTournament newt = creator.createTournament(course, name, startDate);
		repository.save(newt);
		return newt;
	}

	@Override
	public void delete(MatchPlayTournament headontournament) {
		repository.delete(headontournament);
	}

	@Override
	public List<MatchPlayTournament> findAll() {
		return repository.findAll();
		
	}

	@Override
	public MatchPlayTournament findOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public PlayOffTree getPlayOffTree(Long id) {
		MatchPlayTournament tournament = findOne(id);
		return tournament.getPlayOffs();
	}

	@Override
	public List<Bracket> getBrackets(Long id) {
		MatchPlayTournament tournament = findOne(id);
		return tournament.getBrackets();
	}

	@Override
	public PlayOffTree addPlayoffMatchResults(Long id, Long playerSocial, Integer roundNum) {
		MatchPlayTournament tournament = findOne(id);
		PlayOffTree playoffs = tournament.getPlayOffs();
		System.out.println("playoffSize: " + playoffs.getRounds().size());
		PlayOffRound thisRound = playoffs.getRounds().get((int) roundNum);
		System.out.println("matches in round: " + thisRound.getMatches().size());
		System.out.println("players in match: " + playoffs.getRounds().get((int) roundNum).getMatches().get(0).getPlayers().size());
		
		Golfer golfer = new Golfer();
		int matchIndex = 0;
		for(int i = 0; i < thisRound.getMatches().size(); i++) {
			if(thisRound.getMatches().get(i).getPlayers().get(0).getSocial() == (long) playerSocial) {
				golfer = thisRound.getMatches().get(i).getPlayers().get(0);
				matchIndex = i;
				break;
			}
			else if(thisRound.getMatches().get(i).getPlayers().get(1).getSocial() == (long) playerSocial) {
				golfer = thisRound.getMatches().get(i).getPlayers().get(1);
				matchIndex = i;
				break;
			}
		}
		
		PlayOffRound nextRound = playoffs.getRounds().get((int) (roundNum+1));
		nextRound.setMatches(sortByID(nextRound.getMatches()));
		System.out.println("MatchIndex: " + matchIndex);
		System.out.println("fyrir get: " + nextRound.getMatches().get(0).toString());
		//System.out.println("fyrir get: " + nextRound.getMatches().get(1).toString());
		List<Golfer> golfers = nextRound.getMatches().get(matchIndex/2).getPlayers();

		System.out.println("fyrir add: " + nextRound.getMatches().get(0).toString());
		
		if(golfers == null) golfers = new ArrayList<Golfer>(2);
		if(golfers.size() < 2) {
			golfers.add(golfer);
			Match newMatch = nextRound.getMatches().get(matchIndex/2);
			newMatch.setPlayers(golfers);
			newMatch.setResults("ongoing");
			
			System.out.println("Golfers in match " + matchIndex/2 + " in round " + (int) (roundNum+1) + " are:");
			System.out.println(golfers);
			
			System.out.println("fyrir set: " + nextRound.getMatches().get(0).toString());
			nextRound.setMatch(matchIndex/2, newMatch);
			System.out.println("eftir set: " + nextRound.getMatches().get(0).toString());
			playoffs.setRound(roundNum+1, nextRound);
			tournament.setPlayOffs(playoffs);
			
			tournament = repository.save(tournament);
			
			System.out.println(tournament.getPlayOffs().getRounds().get(1).getMatches().get(0).getPlayers());
		}
		
		return playoffs;
		
	}
	
	private List<Match> sortByID(List<Match> matches) {
		for(int i = 1; i < matches.size(); i++) {
			Match keymatch = matches.get(i);
	        Long key = matches.get(i).getid();
	        int k = i - 1;
	        while(k >= 0 && matches.get(k).getid() > key) {
	            matches.set(k+1, matches.get(k));
	            k--;
	        }
	        matches.set(k+1, keymatch);
	    }
		return matches;
	}

}
