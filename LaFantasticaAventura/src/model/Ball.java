package model;

public class Ball {
	
	public int starsQuanty;
	public String url;
	public boolean catched=false;
	
	public Ball(int starsQuanty) {
		super();
		this.starsQuanty = starsQuanty;
		this.url = "/esferas/"+starsQuanty+"a.png";
		
	}
	
	
	
	
}
