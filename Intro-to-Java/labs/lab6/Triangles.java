package lab6;

import sedgewick.StdDraw;

public class Triangles {
	public static void triangle(double x, double y, double a) {
		if(a<=0.01) {
			return;
		}
		 double x1 = x;
         double y1 = y + Math.sqrt(3)*a/3;
         double x2 = x - a/2;
         double y2 = y - Math.sqrt(3)*a/6;
         double x3 = x + a/2;
         double y3 = y - Math.sqrt(3)*a/6;
         double midX12 = (x1+x2)/2;
 		 double midX13 = (x1+x3)/2;
 		 double midX23 = (x3+x2)/2;
 		 double midY12 = (y1+y2)/2;
 		 double midY13 = (y1+y3)/2;
 		 double midY23 = (y3+y2)/2;
 		 double centerX1 = x;
 		 double centerY1 = midY12 + Math.sqrt(3)*a/12;
 		 double centerX2 = midX12;
 		 double centerY2 = midY12 - Math.sqrt(3)*a/6;	
 		 double centerX3 = midX13;
 		 double centerY3 = centerY2;
 		 
         StdDraw.line(x2, y2, x1, y1);
         StdDraw.line(x3, y3, x1, y1);
         StdDraw.line(x2, y2, x3, y3);
         StdDraw.line(midX12, midY12, midX13, midY13);
         StdDraw.line(midX12, midY12, midX23, midY23);
         StdDraw.line(midX13, midY13, midX23, midY23);   
         triangle(centerX3,centerY3,a/2);
         triangle(centerX1,centerY1,a/2);
         triangle(centerX2,centerY2,a/2);
         
	}
	public static void main(String[] args) {
		StdDraw.setXscale(-1, +1);
		StdDraw.setYscale(-1, +1);
		triangle(0, 0, 1);
	}
	
	
}
