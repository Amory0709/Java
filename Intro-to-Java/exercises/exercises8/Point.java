package exercises8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Point {
	
	//
	// has-a x and y coordinate, both integers
	//  these are immutable so you should declare them "final"
	//
	// declare instance variables here:
	//
	private final int x,y;


	//constructor
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	//generate getter
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
//	public String toString() {
//		return "("+this.x+","+this.y+")";
//	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
//		return 0;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
//			return false;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (this.x != other.x)
			return false;
		if (this.y != other.y)
			return false;
		return true;
//		return false;
	}


	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	public static void main(String[] args) {
		Point p1 = new Point(1,2);
		System.out.println(p1);
		List<Point> set = new LinkedList<Point>();
		set.add(new Point(131, 132));
		set.add(new Point(131, 132));
		set.add(new Point(130, 132));
		System.out.println(set.contains(new Point(131,132)));
		System.out.println("Set has "+set);
	}


}
