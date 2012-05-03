package com.sw.project;

import java.applet.Applet;
import java.awt.BorderLayout;

public class StarPolyApplet extends Applet {
	private static final long serialVersionUID = 1L;

	
	private Frame starPoly = new Frame();
	
	public void init(){
		setLayout(new BorderLayout());
		add(starPoly);
	}
	
	public void start(){
		starPoly.start();
	}
	
	public void stop(){
		starPoly.stop();
	}
}
