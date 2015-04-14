package autooop;

import processing.core.PApplet;


@SuppressWarnings("serial")
public class AutoOOP extends PApplet {

	Car auto1;
	Car auto2;
	
	public void setup() {
		size(500,500);
		auto1 = new Car();
		auto2 = new Car();
	}

	public void draw() {
		background(255);
		auto1.zeige();
		auto1.drive();
		auto2.zeige();
		auto2.drive();
	}
	
	
	class Car {
	
	  int xpos, ypos;
	  int laenge, hoehe;
	  int radD;
	  int xspeed;
	  
	  Car() {
	    
	    laenge = 50;
	    hoehe = 20;
	    radD=laenge/3;
	    xspeed = 1;
	    xpos=0;
	    ypos = (int) random(height-50);
	  }
	  
	  void zeige() {
	    fill(230,230,0);
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
}