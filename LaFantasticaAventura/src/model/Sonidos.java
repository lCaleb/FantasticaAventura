package model;

import java.applet.Applet;
import java.applet.AudioClip;



public class Sonidos {
	
	public static final int VUELO=0;
	public static final int PODER=1;
	public static final int ESFERA=2;
	public static final int ESFERAI=4;
	public static final int CLICK=5;
	public static final int STOP=3;
	
	
private AudioClip poder;
private AudioClip esferaValida;
private AudioClip esferaInvalida;
private AudioClip vuelo;
private AudioClip audio;

private AudioClip click;




	public Sonidos(){
		 
		
		poder = Applet.newAudioClip(getClass().getResource("/recursos/audio/wallhit (1).wav"));
		esferaValida = Applet.newAudioClip(getClass().getResource("/recursos/audio/esfera.wav"));
		click=Applet.newAudioClip(getClass().getResource("/recursos/audio/esfera.wav"));
		esferaInvalida =Applet.newAudioClip(getClass().getResource("/recursos/audio/toque.wav"));
		vuelo=Applet.newAudioClip(getClass().getResource("/recursos/audio/volar.wav"));
		audio = Applet.newAudioClip(getClass().getResource("/recursos/audio/soundBack.wav"));
	}

	public void sonido(int tipo){
		if(tipo==VUELO) {
			vuelo.play();
		}
		else if(tipo==PODER) {
			poder.play();
		}else if(tipo==ESFERA) {
				esferaValida.play();
		}else if(tipo==ESFERAI) {
			esferaInvalida.play();
		}else if(tipo==CLICK) {
			click.play();
	   }else if(tipo==STOP) {
			vuelo.stop();
			poder.stop();
		}else if(tipo==9) {
			audio.loop(); 
		}
	}
	
}
	



