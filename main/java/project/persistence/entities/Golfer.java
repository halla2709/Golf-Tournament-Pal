package project.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Golfer") 
public class Golfer implements Comparable<Golfer> {
	
	private String name;
	
    @Id
	private long social;
    
	private double handicap;
	private String email;
	
	public Golfer(String name, long social, double handicap, String email) {
		this.name = name;
		this.social = social;
		this.handicap = handicap;
		this.email = email;
	}
	
	public Golfer() {
		super();
		
	}
	
	@Column(name="golfer_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSocial() {
		return social;
	}

	public void setSocial(long social) {
		this.social = social;
	}

	public double getHandicap() {
		return handicap;
	}

	public void setHandicap(double handicap) {
		this.handicap = handicap;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int compareTo(Golfer g1) {
		Double handicap = (Double) this.getHandicap();
		return handicap.compareTo(g1.getHandicap());
	}
	
	@Override
	public String toString() {
		return "Golfer [name=" + name + " handicap=" + handicap + "]";
	}

}
