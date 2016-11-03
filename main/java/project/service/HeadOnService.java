package project.service;

import java.util.List;

import project.persistence.entities.Golfer;
import project.persistence.entities.HeadOnTournament;
import java.util.List;

public interface HeadOnService {
	
	HeadOnTournament save(HeadOnTournament headontournament);
	
	void delete(HeadOnTournament headontournament);
	 /**
     * Save a {@link HeadOnTournament}
     * @param matchPlay {@link HeadOnTournament} to be saved
     * @return {@link HeadOnTournament} that was saved
     */

    /**
     * Get all {@link HeadOnTournament}s
     * @return A list of {@link HeadOnTournament}s
     */
    List<HeadOnTournament> findAll();

    /**
     * Get all {@link HeadOnTournament}s in a reverse order
     * @return A reversed list of {@link HeadOnTournament}s
     */
    List<HeadOnTournament> findAllReverseOrder();

    /**
     * Find a {@link HeadOnTournament} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link HeadOnTournament} with {@link Long id}
     */
    HeadOnTournament findOne(Long id);

}

