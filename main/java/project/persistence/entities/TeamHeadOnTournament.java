package project.persistence.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TeamHeadOnTournament")
@DiscriminatorValue("Team")
public class TeamHeadOnTournament extends HeadOnTournament {

	@OneToMany(cascade = CascadeType.ALL)
	private List<Team> teams;
	
	public TeamHeadOnTournament(String course, Date startDate, int numberOfRounds, List<Golfer> players, 
			boolean areBrackets, List<Bracket> brackets, PlayOffTree playOffs) {
		super(course, startDate, players, areBrackets, brackets, playOffs);
	}
	
	public static void main(String[] args){
		TeamHeadOnTournament teamHeadOnTournament = new TeamHeadOnTournament("Flottasti völlurinn", new Date(), 3,
				null, true, null, null);
		System.out.println(teamHeadOnTournament.getCourse());
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	
}
