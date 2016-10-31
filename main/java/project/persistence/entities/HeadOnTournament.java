package project.persistence.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HeadOnTournament") 
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TeamTournament")
public class HeadOnTournament extends Tournament{


	private boolean areBrackets;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Bracket> brackets;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PlayOffTree playOffs;
	
	public HeadOnTournament(String course, Date startDate, List<Golfer> players, 
			boolean areBrackets, List<Bracket> brackets, PlayOffTree playOffs) {
		super(course, startDate, players);
		this.areBrackets = areBrackets;
		this.brackets = brackets;
		this.playOffs = playOffs;
	}
	
	public static void main(String[] args) {
		HeadOnTournament ht = new HeadOnTournament("mammmaaaaa'in", new Date(), null, true, null, null);
		System.out.println(ht.getCourse());
	}

	@Override
	public String toString() {
		return "HeadOnTournament [playOffs=" + playOffs + "]";
	}

	public boolean isAreBrackets() {
		return areBrackets;
	}

	public void setAreBrackets(boolean areBrackets) {
		this.areBrackets = areBrackets;
	}

	public List<Bracket> getBrackets() {
		return brackets;
	}

	public void setBrackets(List<Bracket> brackets) {
		this.brackets = brackets;
	}

	public PlayOffTree getPlayOffs() {
		return playOffs;
	}

	public void setPlayOffs(PlayOffTree playOffs) {
		this.playOffs = playOffs;
	}
}
