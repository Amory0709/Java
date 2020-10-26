package exercises2;

import cse131.ArgsProcessor;

public class CarefulDivide {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int numerator   = ap.nextInt("Enter numerator");
		int denominator = ap.nextInt("Enter denominator");

		// Compute numerator / denominator
		//  as an int result
		// BUT if the division has the denominator
		//   as zero, print some error message
		//   instead of the quotient
		// Otherwise, print the quotient
		//
        if(denominator==0) {
        	System.out.println("Error: Denominator cannot be zero!!");
        }
        else {
        	 int quoient = numerator / denominator;
        	 System.out.println("The integer quoient of "+numerator +" and "+ denominator+ " is "+ quoient);
        }
       

	}

}
