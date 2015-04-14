package orgel6;

import processing.core.PApplet;
import ddf.minim.*;


@SuppressWarnings("serial")
public class Orgel6 extends PApplet {


	Minim minim;
	  AudioSample[] ton = new AudioSample[8];
	  AudioSample gesamt;
	  int[] folge = new int[6];
	  int[] spiel = new int[6];
	  int num=0, btn;
	  int zaehler=0;
	  boolean blink=false;
	  
	  
	  public void setup() {
	    size(600,600);
	    frameRate(1);
	    initSpiel();
	    tastenfeld();
	  }
	  

	  public void draw() {
	    if (blink) {
	      tastenfeld();
	      blink=false;
	    }
	    
	    if (zaehler==6) {
	      for (int i=0;i<6;i++)
	        print(folge[i]);
	      println();
	      int match=0;
	      for (int i=0;i<6;i++) {
	        if (folge[i]==spiel[i])
	          match++;
	      }
	      if (match==6) {
	        fill(255,255,0);
	        textSize(40);
	        textAlign(CENTER,CENTER);
	        text("Korrekt",300,250);
	         fill(0,0,255);
	         textSize(22);
	        text("Song: DorFuchs ",300,310);
	        fill(0,0,255);
	        textSize(18);
	 
	        text("DorFuchs auf YouTube: http://www.youtube.com/DorFuchs",300,350);
	        //delay(1000);
	        gesamt.trigger();
	        
	        stop();
	      }
	      else {
	        fill(255,255,0);
	        textSize(40);
	        textAlign(CENTER,CENTER);
	        text("Leider",300,250);
	        text(" nein ",300,350);
	        blink=true;
	        zaehler=0;
	      }
	      
	    }  
	    else {
	      fill(255,255,0);
	      textSize(40);
	      textAlign(CENTER,CENTER);
	      text("Reset",300,250);
	      text("  ",300,350);
	      text(zaehler,300,350);
	    }
	  }
	  
	  
	  public void mousePressed() {
	    int x, y;
	    if (zaehler<6) {
	      zaehler++;
	      x=mouseX/200;
	      y=mouseY/200;
	      btn=x+3*y;
	      if (btn==4) {
	        zaehler=0;
	        println();
	        blinkBtn(x,y);
	        blink=true;
	      }
	      else {
	        if (btn>5)
	          btn=btn-3;
	        print(btn);
	        spiel[zaehler-1]=btn;
	        blinkBtn(x,y);
	        ton[btn].trigger();
	        blink=true;
	        
	        
	      }
	    }
	    delay(200);
	  }
	  
	  
	  void initSpiel() {
	    boolean[] number = new boolean[6];
	    int zahl;
	    
	    for (int i=0; i<6;i++)
	      number[i]=false;
	    
	    for (int i=0;i<6;i++) {
	      do {
	        zahl = (int) random(6);
	      }
	      while (number[zahl]);
	      number[zahl]=true;
	      folge[i]=zahl;
	    }
	    
	    for (int i=0;i<6;i++)
	      print(folge[i]);
	    println();
	    
	    minim = new Minim(this);
	    
	    gesamt=minim.loadSample("0.mp3");
	    
	    for (int i=0;i<6;i++) {
	       switch (i) {
	       case 0: ton[folge[i]]=minim.loadSample("1.mp3");break;
	       case 1: ton[folge[i]]=minim.loadSample("2.mp3");break;
	       case 2: ton[folge[i]]=minim.loadSample("3.mp3");break;
	       case 3: ton[folge[i]]=minim.loadSample("4.mp3");break;
	       case 4: ton[folge[i]]=minim.loadSample("5.mp3");break;
	       case 5: ton[folge[i]]=minim.loadSample("6.mp3");break;
	       }
	    }
	  }
	  
	  
	  void tastenfeld() {
	    int breite=180, hoehe=180;
	    int r,g,b;
	    int posX,posY;

	    for (int i=0; i<3; i++) {
	      for (int j=0; j<3; j=j+2) {
	        posX=200*i+10;
	        posY=200*j+10;
	        r=250-100*i;
	        g=50+100*j;
	        b=50+50*i+50*j;
	        fill(r,g,b);
	        rect(posX,posY,breite, hoehe);
	      }
	      
	    }
	    fill(150,150,150);
	    rect(210,210,breite, hoehe);
	  }
	  
	  
	  void blinkBtn(int i, int j) {
	    int breite=180, hoehe=180;
	    
	    int posX,posY;
	    
	    posX=200*i+10;
	    posY=200*j+10;
	    
	    fill(255);
	    rect(posX,posY,breite, hoehe);
	  }
	  
	  public void stop() {
	    delay(15000);
	    for (int i=0;i<6;i++) {
	      ton[i].close();
	    }
	    minim.stop();
	    super.stop();
	  }

}
