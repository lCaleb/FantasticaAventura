package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.PriorityQueue;

import model.Player;

public class StartGame {
	
    PriorityQueue<Player> queue;
	
	public StartGame() throws IOException {
		queue= new PriorityQueue<Player>();
				//recuperar();
				//new PriorityQueue<Player>();
	}
	
	public void guardar() throws IOException {
		File archivo = new File ("data/archivo.dat");
		FileOutputStream fos= new FileOutputStream(archivo,true);
        ObjectOutputStream oos= new ObjectOutputStream(fos);
        oos.writeObject(queue);
        oos.close();
        fos.close();
	}
	
	@SuppressWarnings("unchecked")
	public PriorityQueue<Player> recuperar() throws IOException {
		File archivo = new File ("data/archivo.dat");
		FileInputStream fis = new FileInputStream(archivo);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
			queue =  (PriorityQueue<Player>) ois.readObject();
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
