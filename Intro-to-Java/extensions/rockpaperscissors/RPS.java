package rockpaperscissors;

import cse131.ArgsProcessor;

public class RPS {

	public static void main(String[] args) {
	ArgsProcessor ap = new ArgsProcessor(args);	
	 int round = ap.nextInt("How many rounds do you want to play?");
	 int rpsInput;
	 int humanWinNum = 0;
	 int realWinNum = 0;
	 for(int i = 0;i < round;++i) {
	    	int realChoice = (int)(3 * Math.random());
	    	rpsInput= ap.nextInt("Rock for 0? Paper for 1? Scissor for 2?");
	    	 while(rpsInput<0 || rpsInput>2) {
	    	    	System.out.println("Invalid Option!Please enter among 0,1,2!");
	    	    	rpsInput = ap.nextInt("Rock for 0? Paper for 1? Scissor for 2?");
	    		}
	    	 System.out.println("real choice "+realChoice);
	    	 System.out.println("human input "+rpsInput);
	    	 
	    	 if(realChoice == rpsInput) {
	    	    	System.out.println("Even!");
	    	 }
	    	 else if(realChoice == 1 && rpsInput == 0) {
	    		    System.out.println("Real wins!");
	    		    realWinNum = realWinNum + 1;
	    	 }
	    	 else if(realChoice == 0 && rpsInput == 1) {
	    		    System.out.println("Human wins!");
	    		    humanWinNum = humanWinNum + 1;
	    	 }
	    	 else if(realChoice == 2 && rpsInput == 1) {
	    		    System.out.println("Real wins!");
	    		    realWinNum = realWinNum + 1;
	    	 }
	    	 
	    	 else if(realChoice == 1 && rpsInput == 2) {
	    		    System.out.println("Human wins!");
	    		    humanWinNum = humanWinNum + 1;
	    	 }
	    	 else if(realChoice == 0 && rpsInput == 2) {
	    		    System.out.println("Real wins!");
	    		    realWinNum = realWinNum + 1;

	    	 }
	    	 else if(realChoice == 2 && rpsInput == 0) {
	    		    System.out.println("Human wins!");
	    		    humanWinNum = humanWinNum + 1;
	    	 }
	    	 System.out.println("Human win fraction"+humanWinNum+"/"+round);
	    	 System.out.println("Real win fraction"+realWinNum+"/"+round);

	    } 
   }
	

}
