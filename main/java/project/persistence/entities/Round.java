package project.persistence.entities;

import javax.persistence.Transient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	private int h1;
	private int h2;
	private int h3;
	private int h4;
	private int h5;
	private int h6;
	private int h7;
	private int h8;
	private int h9;
	private int h10;
	private int h11;
	private int h12;
	private int h13;
	private int h14;
	private int h15;
	private int h16;
	private int h17;
	private int h18;
	private int total;
	
	@Transient()
	private int[] myScores = {h1,h2,h3,h4,h5,h6,h7,h8,h9,h10,h11,h12,h13,h14,h15,h16,h17,h18};
	
	public Round() {
	}
	
	public int getTotal() {
		total = 0;
		for(int i = 0; i < 18; i++) {
			total += myScores[i];
		}
		return total;
	}
	public void setScore(int[] scores) {
		myScores = scores;
		h1 = scores[0];
		h2 = scores[1];
		h3 = scores[2];
		h4 = scores[3];
		h5 = scores[4];
		h6 = scores[5];
		h7 = scores[6];
		h8 = scores[7];
		h9 = scores[8];
		h10 = scores[9];
		h11 = scores[10];
		h12 = scores[11];
		h13 = scores[12];
		h14 = scores[13];
		h15 = scores[14];
		h16 = scores[15];
		h17 = scores[16];
		h18 = scores[17];
		total = getTotal();
	}
	
	public int getScore(int i) {
		return myScores[i];
	}
	
	public int[] getMyScores() {
		return myScores;
	}
	
	public static void main(String[] args) {
		Round round = new Round();
		int[] hallo = new int[18];
		hallo[0] = 5;
		hallo[3] = 8;
		round.setScore(hallo);
		System.out.println(round.getScore(0));
		
	}
}
