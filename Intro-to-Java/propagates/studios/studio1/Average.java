package studio1;

import cse131.ArgsProcessor;

public class Average {
	
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
	
		int n1 = ap.nextInt("The first number is");
		int n2 = ap.nextInt("THe second number is ");
		
		int avg = (n1+n2)/2;
	
	System.out.println("The first number is "+n1+",");
	System.out.println("The second number is "+n2+",");
	System.out.println("The average of the tow number is "+ avg+".");
	}
}
