package exercises2;

import cse131.ArgsProcessor;

public class FeetInches {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		
		
		// Prompt the user for a number of inches
		int inches = ap.nextInt("How many inches would you like to convert?");
		// Convert that into feet and inches
		//   BUT
		// Be sure to use the singular "foot" or "inch"
		//   where appropriate, as discussed in
		//   the introductory video
		//
		// For example, 61 inches would produce
		//    the output
		//   5 feet and 1 inch
		//
		int feet = inches / 12;
		inches = inches % 12;
        if(feet==1) {
        	if(inches==1) {
        		System.out.println("The result of convertion is "+feet+" foot " + inches + " inch." );
        	}
        	else {
        		System.out.println("The result of convertion is "+feet+" foot " + inches + " inches." );	
        	}	
        }
        else {
        	if(inches==1) {
        		System.out.println("The result of convertion is "+feet+" feet " + inches + " inch." );
        	}
        	else {
        		System.out.println("The result of convertion is "+feet+" feet " + inches + " inches." );		
            }
	    }
	}
}



