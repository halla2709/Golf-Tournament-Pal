package project.service;

import java.util.Date;
import java.util.List;

import project.persistence.entities.Bracket;
import project.persistence.entities.Golfer;
import project.persistence.entities.MatchPlayTournament;
import project.persistence.entities.PlayOffTree;

public interface MatchPlayService {
	
	MatchPlayTournament save(boolean areBrackets, List<Golfer> players, int numInBracket, int numOutOfBrackets, String course, String name, Date startDate);
	
	void delete(MatchPlayTournament headontournament);
	 /**
     * Save a {@link HeadOnTournament}
     * @param matchPlay {@link HeadOnTournament} to be saved
     * @return {@link HeadOnTournament} that was saved
     */

    /**
     * Get all {@link MatchPlayTournament}s
     * @return A list of {@link MatchPlayTournament}s
     */
    List<MatchPlayTournament> findAll();

    /**
     * Find a {@link MatchPlayTournament} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link MatchPlayTournament} with {@link Long id}
     */
    MatchPlayTournament findOne(Long id);

	PlayOffTree getPlayOffTree(Long id);

	List<Bracket> getBrackets(Long id);

}

