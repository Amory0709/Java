package exercises1;

import cse131.ArgsProcessor;

public class Change {

	public static void main(String[] args) {
		//
		// Below, prompt the user to enter a number of pennies
		//
		ArgsProcessor ap=new ArgsProcessor(args);
		int penny=ap.nextInt("How many pennies?");
		//code resource:https://zhidao.baidu.com/question/205051055.html
		//
		// Then, compute and print out how many 
		//    dollars, quarters, dimes, nickels, and pennies
		// should be given in exchange for those pennies, so as to
		// minimize the number of coins (see the videos)
		//
		int dollar=penny / 100;
		penny=penny % 100;
		int quarter=penny / 25;
		penny=penny % 100;
		int dime=penny / 10;
		penny=penny % 10;
		int nickle=penny / 5;
		penny=penny % 5;
		System.out.println("There are "+dollar+" dollars "+quarter+" quarters "+dime+" dimes "+nickle+" nickles "+penny+" pennies.");

	
	}

}
