package project.persistence.entities;

public class Golfer {
	
	String name;
	int social;
	double handicap;
	String email;
	
	public Golfer(String name, int social, double handicap, String email) {
		this.name = name;
		this.social = social;
		this.handicap = handicap;
		this.email = email;
	}
	
	public static void main(String[] args) {
		Golfer halla = new Golfer("Halla", 93939393, 4.3, "hallamammain");
		System.out.println(halla.social);
	}
}
