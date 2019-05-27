package model;

import java.applet.Applet;
import java.applet.AudioClip;

public class SonidoFondo{

	private AudioClip audio;
	
	public SonidoFondo(){
		audio = Applet.newAudioClip(getClass().getResource("/recursos/audio/soundBack.wav"));
		audio.play();
	}

	public void detenerSonido(){
		audio.stop();
	}
}
