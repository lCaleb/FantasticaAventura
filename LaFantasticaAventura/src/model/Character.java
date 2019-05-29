package model;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Character {

	public static final int STAT = 0;
	public static final int UP = 1;
	public static final int LEFT = 2;
	public static final int DOWN = 3;
	public static final int RIGHT = 4;
	public String name;
	public String url;

	public boolean left;
	public boolean right;
	public boolean up;
	public boolean down;
	public boolean powerLeft;
	public boolean powerRight;
	public int direction;
	

	

	public int x = 425;
	public int y = 530;

	public Character(String name) {
		super();
		this.name = name;
		this.url = "/Character/" + name + "/0.png";
		this.left = false;
		this.right = false;
		this.up = false;
		this.down = false;
		
	}

	public void motus() {
		

			if (down) {
				if (y > 500) {
					setImage(3);
				} else {
					y = y + 1;
					 setImage(3);
				}
			} else if (up) {
				if (y < 0) {
					setImage(1);
				} else {
					y = y - 1;
					setImage(1);
				}

			} else if (right) {
				if (x > 820) {
					setImage(4);
				} else {
					setImage(4);
					x += 1;
				}
			} else if (left) {
				if (x < 0) {
					setImage(2);
				} else {
					setImage(2);
					x = x - 1;
				}
			} else {
				if (powerLeft) {
					setImage(1+"");
				}else if(powerRight) {
					setImage(2+"");
				}else {
				setImage(0);
				}
			}

	}
	
	public void setImage(String direction) {
		this.url = "/Character/" + name + "/lanzar/"+direction+".png";
	}
	
	public void setImage(int direction) {
		this.url = "/Character/" + name + "/"+direction+".png";
	}

}