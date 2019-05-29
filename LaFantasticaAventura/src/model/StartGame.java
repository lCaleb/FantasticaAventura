package model;

import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.PriorityQueue;

import Graph1.Edge;
import Graph1.Graph;
import model.Player;

public class StartGame {

	PriorityQueue<Player> queue;

	ArrayList<Ball> balls;

	private Character character;

	private Sonidos sound;
	
	private Graph<String,PointM> graph;
	
	public PointM[] points;
	
	public String[] routes;

	// private

	public StartGame() throws IOException {
		sound = new Sonidos();
		queue = new PriorityQueue<Player>();
		balls = new ArrayList<Ball>();
		points = new PointM[30];
		routes= new String[30];
		graph= new Graph<String,PointM>();
		// recuperar();
		// new PriorityQueue<Player>();
		pointsCreator();
	//	addDragonBalls();
	}

	public void catchBall(Ball ball) {
		ball.catched=true;
	}

	public void addDragonBalls() {
		int count = 7;

		while (count > 0) {
			Ball ball = new Ball(count);
			balls.add(ball);
			int randi = (int) (Math.random() * 29) + 1;
			if (!points[randi].haveBall) {
				points[randi].setBall(ball);
				points[randi].haveBall = true;
				count--;
			}

		}
	}

	public int heapNear(double x, double y, double a, double b){
		int coincide=-1;
		for(int i=0; i<points.length;i++){
			if(x>points[i].getX()+a+100||x+70<points[i].getX()+a||y>points[i].getY()+b+130||y+50<points[i].getY()+b){
				System.out.println("no colision");
			}
			else {
				System.out.println("Colision");
				coincide=i;
			}
		}
		return coincide;
		
	}
	
	public void pointsCreator() {

		for (int i = 0; i < points.length; i++) {
			int x = (int) ((Math.random() * 2500) + 1);
			int y = (int) ((Math.random() * 1650) + 1);
			PointM punto = new PointM(x, y);
			points[i] = punto;		
			}
		}
		

		
		// points[0]= new Point(400, 200);
		// points[1]= new Point(520, 700);
		// points[2]= new Point(440, 1100);
		// points[3]= new Point(780, 1500);
		// points[4]= new Point(900, 450);
		// points[5]= new Point(750, 920);
		// points[6]= new Point(1000, 1250);
		// points[7]= new Point(1150, 1500);
		// points[8]= new Point(1000, 200);
		// points[9]= new Point(1500, 700);

	

	public void characterCreator(String name) {
		character = new Character(name);
	}

	public Sonidos getSound() {
		return sound;
	}

	public void setSound(Sonidos sound) {
		this.sound = sound;
	}

	public Point[] getPoints() {
		return points;
	}

	public void setPoints(PointM[] points) {
		this.points = points;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public void guardar() throws IOException {
		File archivo = new File("data/archivo.dat");
		FileOutputStream fos = new FileOutputStream(archivo, true);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(queue);
		oos.close();
		fos.close();
	}

	@SuppressWarnings("unchecked")
	public PriorityQueue<Player> recuperar() throws IOException {
		File archivo = new File("data/archivo.dat");
		FileInputStream fis = new FileInputStream(archivo);
		ObjectInputStream ois = new ObjectInputStream(fis);
		try {
			queue = (PriorityQueue<Player>) ois.readObject();
			System.out.println("pelos");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		ois.close();
		fis.close();
		return queue;
	}

	public PriorityQueue<Player> getQueue() {
		return queue;
	}

	public void setCola(PriorityQueue<Player> queue) {
		this.queue = queue;
	}

}
