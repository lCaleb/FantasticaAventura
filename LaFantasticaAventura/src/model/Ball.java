package model;

public class Ball {
	
	public int starsQuanty;
	public String url;
	public boolean catched=false;
	public PointM point;
	
	public Ball(int starsQuanty,PointM point) {
		super();
		this.point=point;
		this.starsQuanty = starsQuanty;
		this.url = "/esferas/"+starsQuanty+"a.png";
		
	}
	
	
	
	
}
