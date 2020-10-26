package lab1;

import cse131.ArgsProcessor;

public class Nutrition {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		String name = ap.nextString("Name?");
		double carbs = ap.nextDouble("How many carbonhydates?");
		double fat = ap.nextDouble("How much fat?");
		double protein = ap.nextDouble("How much protein?");
		double statedCals = ap.nextDouble("How much stated cals?");
		
		double carbsCals = carbs * 4;
		double fatCals = Math.round(fat * 9);
		double proteinCals = protein * 4;
		double unavailableCals = Math.round(carbsCals + fatCals + proteinCals - statedCals);
		double fiber = unavailableCals / 4.0;
		
		System.out.println(name +"has");
		System.out.println(carbs+" grams of carbohydrates = " +carbsCals + "Calories");
		System.out.println(fat +" grams of carbohydrates = " +fatCals + "Calories");
		System.out.println(protein +" grams of carbohydrates = " +proteinCals + "Calories");
		System.out.println(" ");
		System.out.println("This food is said to have"+ statedCals+" (available) Calories.");
		System.out.println("With"+unavailableCals+" unavailable Calories, this food has "+fiber+" grams of fiber");
		System.out.println(" ");
		System.out.println("Approximately");
		double perCarbsCals = Math.round(1000*carbsCals/statedCals)/10.0;
		double perFatCals = Math.round(1000*fatCals/statedCals)/10.0;
		double perProteinCals = Math.round(1000*proteinCals/statedCals)/10.0;
		
		System.out.println(perCarbsCals+"% of your food is carbohydrates");
		System.out.println(perFatCals+"% of your food is fat");
		System.out.println(perProteinCals+"% of your food is protein");
		System.out.println(" ");
		System.out.println("This food is acceptable for a low-carb diet?  "+  (perCarbsCals<25));
		System.out.println("This food is acceptable for a low-fat diet?" + (perFatCals < 15));
		System.out.println("By coin flip, you should eat this food?  " + (Math.random() < 0.5) );
	
		
	}

}
