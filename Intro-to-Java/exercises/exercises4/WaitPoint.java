package exercises4;

import sedgewick.StdDraw;

public class WaitPoint {

	public static void main(String[] args) {
		// wait for the mouse to be pressed and released
       double x = StdDraw.mouseX();
       double y = StdDraw.mouseY();
		while(!StdDraw.mousePressed()) {
			StdDraw.pause(100);
		}// here, the mouse has been pressed
        System.out.println("Pressed!");
		
		while(StdDraw.mousePressed()) {
			StdDraw.pause(100);	
				}// here the mouse is released
		System.out.println("Released!");
		
		// draw a point at the location of the mouse
		StdDraw.point(x, y);
		
		// here, a q has been typed
		char c = StdDraw.nextKeyTyped();
		System.out.println(c);
		StdDraw.text(0.5, 0.5, "Farewell!");

	}

}
