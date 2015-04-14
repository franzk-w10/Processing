package auto;

import processing.core.PApplet;


@SuppressWarnings("serial")
public class Auto extends PApplet {

	int xpos, ypos;
	int laenge, hoehe;
	int radD;
	int xspeed;
	
	public void setup() {
		size(500,500);
		laenge = 50;
		hoehe = 20;
		radD=laenge/3;
		xspeed = 1;
		xpos=0;
		ypos = (int) random(height);
		
	}

	public void draw() {
		background(255);
		zeige();
		drive();
	}
	
	public void zeige() {
		fill(200,0,0);
		rect(xpos,ypos,laenge,hoehe);
		fill(0);
		ellipse(xpos,ypos+hoehe,radD,radD);
		ellipse(xpos+laenge,ypos+hoehe,radD,radD);
	}
	
	void drive() {
		   xpos=xpos+xspeed;
		   if (xpos > width) {
		     xpos=0;
		   }
	} 
}
