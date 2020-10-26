package studio6;

import sedgewick.StdDraw;

public class CantorStool {
	private static void cantor(double x, double y, double halfWidth, double halfHeight) {
		if(halfWidth<=0.001) {
			return;
		}
		StdDraw.rectangle(x, y, halfWidth, halfHeight);
		cantor(x+halfWidth-halfWidth/3,y-halfHeight-halfHeight/2,halfWidth/3,halfHeight/2);
		cantor(x-halfWidth+halfWidth/3,y-halfHeight-halfHeight/2,halfWidth/3,halfHeight/2);
		
	}
	public static void main(String[] args) {
		StdDraw.setXscale(-1, +1);
		StdDraw.setYscale(-1, +1);
		cantor(0, 0.5, 0.5,0.2);
	}
}
