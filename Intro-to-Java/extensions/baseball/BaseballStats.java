package baseball;

import cse131.ArgsProcessor;

public class BaseballStats {

	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		
		String name = ap.nextString("Name of the player?");
	
		int atBats = ap.nextInt("The number of at-bats");
		double hits = ap.nextInt("The number of hits");
		double battingAve = Math.round(hits*1000/atBats)/1000.0;
	    if(atBats>200) {
	    	System.out.println(name+" "+battingAve);
			System.out.println("All-star worthy? "+(battingAve>=0.27));
	
	    }
	    else {
	    	System.out.println("a player must have more than 200");
	    }
				

	}

}
