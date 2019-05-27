package model;

import java.awt.Point;

public class PointM extends Point {
	
	public boolean haveBall=false;
	public Ball ball;

	public PointM() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PointM(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public PointM(Point p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	
	public void setBall(Ball ball) {
		this.ball= ball;
	}
	

}
