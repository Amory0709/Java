package studio2;

import cse131.ArgsProcessor;

public class Ruin {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int startAmount = ap.nextInt("Number of money when you start to gamble?");
		double winChance = ap.nextDouble("Possibility of your win?");
		int winAmount = ap.nextInt("Amount of money when you decide not to gamble?");
		int totalPlay = ap.nextInt("The number of times you simulate?");
		
		double lossChance = 1 - winChance;
		//if (lossChance != winChance) 
		//Ruin = ((lossChance/winChance)startAmount - (lossChance/winChance)winAmount) / (1 - (lossChance/winChance)winAmount) 
        //if (lossChance == winChance)
        // Ruin = 1 - startAmount / winAmount
		
		double ruin;
		if(lossChance != winChance) {
			 ruin = (Math.pow(lossChance/winChance, startAmount)-Math.pow(lossChance/winChance, winAmount))/(1-Math.pow(lossChance/winChance, winAmount));
		}
		else {
			 ruin = 1 - (double)startAmount/winAmount; 
		}
		System.out.println("ruin"+ruin);

		 int loseNum=0;
	     int winNum = 0;
	     int k = 0;
	     int i = 0;
		for (k=0;k < totalPlay;k++) {
		//start gamble
			
		int availableMoney = startAmount;
		
		while((availableMoney > 0 )&& (availableMoney < winAmount)) {
		 
		 
				if(Math.random()<winChance) {
					i = i+1;
					availableMoney = availableMoney + 1;
				}
				else {
					i = i+1;
					availableMoney = availableMoney - 1;
				}
		}//while loop
		//end gamble
		
	
		     String gambleResult;
		    
		     if(availableMoney==0) {
			      gambleResult = "LOSE";
			     
			      loseNum = loseNum + 1;
		     }
		     else{
			      gambleResult = "WIN";
			     
			      winNum = winNum +1;
		     }
		     System.out.println("Simulation"+k+":"+i+"rounds          "+gambleResult);
		     
		     i = 0;
		}//for loop
		
		System.out.println("Losses:"+loseNum+ "          Simulations:"+k);
		System.out.println("Actual Ruin Rate:"+(double)loseNum/k+ "   Expected Ruin Rate:"+ ruin);
		
		
	}

}
