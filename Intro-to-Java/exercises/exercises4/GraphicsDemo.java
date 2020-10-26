package exercises4;

import java.awt.Color;

import sedgewick.StdDraw;

public class GraphicsDemo {

	public static void main(String[] args) {
		// blue point (look carefully, will be very small on your screen)
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.point(0.1, 0.9);
		
		// larger green point
		StdDraw.setPenRadius(0.2);
		StdDraw.setPenColor(Color.GREEN);
		StdDraw.point(0.8, 0.8);
		// unfilled red triangle
		StdDraw.setPenRadius(0.001);
		StdDraw.setPenColor(Color.RED);
		StdDraw.line(0.1, 0.1, 0.2, 0.2);
		StdDraw.line(0.2, 0.2, 0.1, 0.2);
		StdDraw.line(0.1, 0.1, 0.1, 0.2);
		// yellow circle, filled
		StdDraw.setPenColor(Color.YELLOW);
		StdDraw.circle(0.5, 0.1, 0.2);
		// filled blue rectangle
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.rectangle(0.6, 0.8, 0.1, 0.2);


	}

}
