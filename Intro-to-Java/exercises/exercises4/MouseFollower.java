package exercises4;

import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.StdDraw;

public class MouseFollower {

	public static void main(String[] args) {
		
		
		while (true) {
			StdDraw.clear();
			//
			// Render one frame of your animation below here
			//
			StdDraw.setPenRadius(0.05);
            StdDraw.point(StdDraw.mouseX(), StdDraw.mouseY());
			
			//  
			// End of your frame
			//
			// Stdraw.show(..) achieves double buffering and
			//   avoids the tight spinning loop
            StdDraw.pause(100);
			StdDraw.show(5);
		}

	}

}
