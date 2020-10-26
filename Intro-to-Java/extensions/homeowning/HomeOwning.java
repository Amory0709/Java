package homeowning;

import cse131.ArgsProcessor;

public class HomeOwning {

	public static void main(String[] args) {
	ArgsProcessor ap = new ArgsProcessor(args);
    String name = ap.nextString("Name of the property?");
    String zipCode = ap.nextString("Zip Code");
    int monthRent = ap.nextInt("Monthly rent");
    double dailyInterest = ap.nextDouble("Daily Interest?");
    System.out.println(name+" is located in the Zip Code "+zipCode);
    System.out.println("Rent per year: "+(12*monthRent));
    System.out.println("Rent per week: "+Math.round((12*monthRent)*700/365.0)/100.0);
    System.out.println("Interest paid per year: "+Math.round(dailyInterest*36500)/100.0);
    System.out.println("Interest paid per week: "+Math.round(700*dailyInterest)/100.0);
    	

	if((12*monthRent) > Math.round(dailyInterest*36500)/100.0) {
		System.out.println("I should buy");
	}
	else {
		System.out.println("I should rent");
	}
	}
}
