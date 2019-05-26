package model;

import java.io.Serializable;



public class Player implements Serializable,Comparable<Player> {

	private String name;
	private double score;
	
	public Player(String name, double score) {
		this.name=name;
		this.score=score;
	}

	public String getName() {
		return name;
	}

	public void setNombre(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public int compareTo(Player o) {
		// TODO Auto-generated method stub
		if(this.getScore()>o.getScore()) {
            return -1;
        } else if (this.getScore()<o.getScore()) {
            return 1;
        } else {
            return 0;
        }
	}
		
}
