package lab4;

import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.StdAudio;
import sedgewick.StdDraw;

public class BumpingBalls {
	
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int ballNum = ap.nextInt("How many balls?");
		int simuNum = ap.nextInt("How many iterations for the simulation?");
		//set the canvas
		StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
		
		double [] velocityX = new double [ballNum];
		double [] velocityY = new double [ballNum];
		double [] positionX = new double [ballNum];
		double [] positionY = new double [ballNum];
		double radius = 0.1;
        	 for(int i = 0; i < ballNum; ++i) {
				
				// initial values velocity
				velocityX[i] = 0.1 * Math.random()+ 0.05;
				velocityY[i] = 0.1 * Math.random()+ 0.05;
				positionX[i] = (-2) * Math.random()+1;
			    positionY[i] = (-2) * Math.random()+1;
        	 }
		        // main animation loop
		        for(int j = 0;j < simuNum ; ++j){ 
		        	for(int i = 0; i < ballNum; ++i) {
		            // bounce off wall according to law of elastic collision
			            if (Math.abs(positionX[i] + velocityX[i]) > 1.0 - radius) {
			            	velocityX[i] = - velocityX[i];
			            	//StdAudio.play("sound/BonkCrsh.wav");
			            }
			            if (Math.abs(positionY[i] + velocityY[i]) > 1.0 - radius) {
			            	velocityY[i] = -velocityY[i];
			            	//StdAudio.play("sound/elaugh.wav");
			            }
		            //bounce off another ball
	                   
			            for(int k = i+1; k < ballNum-1;++k) {
	                       double x = Math.abs(positionX[i] - positionX[k]);
	                       double y = Math.abs(positionY[i] - positionY[k]);
	                       double distance = Math.sqrt(x*x+y*y);
	                       if(distance <= (2 * radius)) {
	                    	   
	                    	   velocityX[i] = -velocityX[i];
	                    	   velocityY[i] = -velocityY[i];
	                    	   
	                    	   velocityX[k] = -velocityX[k];
	                    	   velocityY[k] = -velocityY[k];
	                           
	                    	   
	                       }
	                    }
		            // update position
		            positionX[i] = positionX[i] + velocityX[i]; 
		            positionY[i] = positionY[i] + velocityY[i]; 
		        	}
		            // clear the background
		            //StdDraw.setPenColor(StdDraw.GRAY);
		            //StdDraw.filledSquare(0, 0, 1.0);
	
		            // draw ball on the screen
		        	StdDraw.clear();
		            StdDraw.setPenColor(StdDraw.BLACK);
		        	for(int i = 0; i < ballNum; ++i) {
		        		StdDraw.filledCircle(positionX[i], positionY[i], radius);
		        	}
	
		            //StdDraw.picture(positionX[i], positionY[i], "images/smileyface.gif");
		            // display and pause for 20 ms
		            StdDraw.show(50);
		            //StdDraw.pause(5);
		            }
	}
	}


