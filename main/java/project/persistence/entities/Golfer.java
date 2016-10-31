package project.persistence.entities;

import java.util.Arrays;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Golfer") 
public class Golfer implements Comparable<Golfer>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8509943069522870963L;

	private String name;
	
    @Id
	private int social;
    
	private double handicap;
	private String email;
	
	public Golfer(String name, int social, double handicap, String email) {
		this.name = name;
		this.social = social;
		this.handicap = handicap;
		this.email = email;
	}
	
	public static void main(String[] args) {
		Golfer halla = new Golfer("Halla", 93939393, 4.3, "hallamammain");
		Golfer Elvar = new Golfer("Elvar", 93939393, 5.0, "ilvar");
		Golfer[] golfers = {Elvar, halla};
		Arrays.sort(golfers);	
		System.out.println(golfers[0].getName() + " " + golfers[1].getName());
	}

	@Column(name="golfer_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSocial() {
		return social;
	}

	public void setSocial(int social) {
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
