package eyeballs;

import java.awt.Color;

import sedgewick.StdDraw;
import cse131.ArgsProcessor;

public class Eyeballs {
    /**
     * 
     * @param mx clicked x parameter
     * @param my clicked y parameter
     * @param r1 eye circle radius
     * @param r2 eye ball radius
     */
	public static void createEyeBalls(double mx, double my, double r1, double r2){
		//to create a eyeball where the mouse is clicked
			StdDraw.setPenColor(Color.WHITE);
			StdDraw.filledCircle(mx, my, r1);
			StdDraw.setPenColor(Color.black);
			StdDraw.circle(mx, my, r1);
			StdDraw.filledCircle(mx, my, r2);
	}
	/**
	 * 
	 * @param x the x parameter of eye circle
	 * @param y the y parameter of eye circle
	 * @param rEyeCircle the radius of eye circle
	 * @param rEyeBall the radius of eye ball
	 */
	public static void eyeBallMove(double x, double y, double rEyeCircle, double rEyeBall) {
		//when the mouse move, the eye ball move along
		double mx = StdDraw.mouseX();
		double my = StdDraw.mouseY();
		double distanceX = mx-x;
		double distanceY = my-y;
		double distance = Math.sqrt(distanceX*distanceX+distanceY*distanceY);
		double ratio = (rEyeCircle - rEyeBall)/distance;
		double px = distanceX * ratio;
		double py = distanceY * ratio;
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.filledCircle(x, y, rEyeCircle);
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledCircle(x+px, y+py, rEyeBall);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		StdDraw.picture(0.5, 0.5, "images/ken.jpg");
		int N = ap.nextInt("How many eyeballs?");	
		double rEyeCircle = 0.028;
		double rEyeBall = 0.01;
		double [] eyeBallX = new double [N];
		double [] eyeBallY = new double [N];
		int i = -1;
		while(true) {
						
			if(StdDraw.mousePressed() && i < N-1) {
				while(StdDraw.mousePressed()) {
					
				}
				++i;
				double mx = StdDraw.mouseX();
				System.out.println("add x");
				double my = StdDraw.mouseY();
				System.out.println("add y");
				eyeBallX[i] = mx;
				eyeBallY[i] = my;
				createEyeBalls(eyeBallX[i],eyeBallY[i],rEyeCircle,rEyeBall);
				System.out.println(i);
				System.out.println(N);
				StdDraw.show(50);
			}
			
			while (!StdDraw.mousePressed()) {
			    // do nothing, 
			    // we are waiting for the mouse button to go down  
			    //
			    // The line below is important, as described below
			    //
				for(int j = 0 ; j < N ;++j) {
					if(eyeBallX[j]>0) {
						eyeBallMove(eyeBallX[j],eyeBallY[j],rEyeCircle,rEyeBall);
					}
				}
				
			    StdDraw.show(50);
			}

		}//end of while true
	
		
		
	}
}
